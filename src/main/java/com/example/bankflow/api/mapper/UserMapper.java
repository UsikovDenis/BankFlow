package com.example.bankflow.api.mapper;

import com.example.bankflow.api.dto.user.UserCreateRequest;
import com.example.bankflow.api.dto.user.UserDto;
import com.example.bankflow.api.mapper.decorator.UserMapperDecorator;
import com.example.bankflow.entity.user.User;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    @Mapping(target = "phones", ignore = true)
    @Mapping(target = "emails", ignore = true)
    User createRequestToEntity(UserCreateRequest request);

    @Mapping(target = "phones", ignore = true)
    @Mapping(target = "emails", ignore = true)
    @Mapping(target = "amount", source = "bankAccount.amount")
    UserDto toDto(User user);
}
