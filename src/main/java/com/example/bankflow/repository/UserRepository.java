package com.example.bankflow.repository;

import com.example.bankflow.api.dto.user.UserSearchRequest;
import com.example.bankflow.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;


import static com.example.bankflow.repository.specification.UserSpecification.*;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {

    default Page<User> findPageBySearchRequest(UserSearchRequest userSearchRequest) {
        Specification<User> specification = Specification.where(
                distinct()
                        .and(equalsPhone(userSearchRequest))
                        .and(equalsEmail(userSearchRequest))
                        .and(likeFullName(userSearchRequest))
                        .and(beforeBirthDate(userSearchRequest))
        );

        return findAll(specification, userSearchRequest.getPageable());
    }

}
