package com.example.bankflow.api.mapper.decorator;


import com.example.bankflow.api.dto.user.UserCreateRequest;
import com.example.bankflow.api.dto.user.UserDto;
import com.example.bankflow.api.error.ValidationException;
import com.example.bankflow.api.mapper.UserMapper;
import com.example.bankflow.entity.user.BankAccount;
import com.example.bankflow.entity.user.Email;
import com.example.bankflow.entity.user.Phone;
import com.example.bankflow.entity.user.User;
import com.example.bankflow.repository.EmailRepository;
import com.example.bankflow.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static com.example.bankflow.api.error.ApiErrorMessage.BAD_REQUEST_EMAIL;
import static com.example.bankflow.api.error.ApiErrorMessage.BAD_REQUEST_PHONE;

public abstract class UserMapperDecorator implements UserMapper {
    @Autowired
    private UserMapper delegate;
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private EmailRepository emailRepository;

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = delegate.toDto(user);

        userDto.setPhones(user.getPhones().stream()
                .map(Phone::getNumber)
                .toList());

        userDto.setEmails(user.getEmails().stream()
                .map(Email::getAddress)
                .toList());

        return userDto;
    }


    @Override
    public User createRequestToEntity(UserCreateRequest request){
        User user = delegate.createRequestToEntity(request);

        if (phoneRepository.existsByNumber(request.getPhone())) {
            throw new ValidationException(BAD_REQUEST_PHONE);
        }
        if (emailRepository.existsByAddress(request.getEmail())) {
            throw new ValidationException(BAD_REQUEST_EMAIL);
        }

        user.setEmails(Collections.singletonList(Email.builder()
                .address(request.getEmail())
                .user(user)
                .build()));

        user.setPhones(Collections.singletonList(Phone.builder()
                .number(request.getPhone())
                .user(user)
                .build()));

        user.setBankAccount(BankAccount.builder()
                .amount(request.getAmount())
                .user(user)
                .build());

        return user;
    }
}
