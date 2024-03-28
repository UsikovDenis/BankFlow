package com.example.bankflow.repository.specification;

import com.example.bankflow.api.dto.user.UserSearchRequest;
import com.example.bankflow.entity.user.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import static com.example.bankflow.utils.Utils.addPercentsAndUpper;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserSpecification {

    public static Specification<User> distinct() {
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            query.distinct(true);
            return null;
        };
    }

    public static Specification<User> equalsPhone(UserSearchRequest userSearchRequest) {
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (isEmpty(userSearchRequest.getPhone())) {
                return null;
            }
            return criteriaBuilder.equal(root.get("phones").get("number"), userSearchRequest.getPhone());
        };
    }

    public static Specification<User> equalsEmail(UserSearchRequest userSearchRequest) {
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (isEmpty(userSearchRequest.getEmail())) {
                return null;
            }
            return criteriaBuilder.equal(
                    criteriaBuilder.upper(root.get("emails").get("address")),
                    userSearchRequest.getEmail().toUpperCase());
        };
    }

    public static Specification<User> likeFullName(UserSearchRequest userSearchRequest) {
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (isEmpty(userSearchRequest.getFullName())) {
                return null;
            }
            return criteriaBuilder.like(
                    criteriaBuilder.upper(root.get("fullName")),
                    addPercentsAndUpper(userSearchRequest.getFullName()));
        };
    }


    public static Specification<User> beforeBirthDate(UserSearchRequest userSearchRequest) {
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (isNull(userSearchRequest.getBirthDate())) {
                return null;
            }
            return criteriaBuilder.greaterThan(root.get("birthDate"),
                    userSearchRequest.getBirthDate());
        };
    }

}
