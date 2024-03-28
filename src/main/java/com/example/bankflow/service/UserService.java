package com.example.bankflow.service;


import com.example.bankflow.api.dto.user.UserCreateRequest;
import com.example.bankflow.api.dto.user.UserDto;
import com.example.bankflow.api.dto.user.UserSearchRequest;
import com.example.bankflow.api.mapper.UserMapper;
import com.example.bankflow.entity.user.BankAccount;
import com.example.bankflow.entity.user.User;
import com.example.bankflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class UserService {

    private static final float ONE_HUNDRED_PERCENT = 100;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Value("${application.max-deposit-percent:207}")
    private float maxDepositPercent;

    @Transactional
    public UserDto create(UserCreateRequest userCreateRequest) {
        User user = userMapper.createRequestToEntity(userCreateRequest);
        BankAccount bankAccount = user.getBankAccount();
        bankAccount.setMaxAmount(bankAccount.getAmount()
                .add(bankAccount.getAmount().multiply(new BigDecimal(maxDepositPercent / ONE_HUNDRED_PERCENT))));
        return userMapper.toDto(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    public Page<UserDto> getPageBySearchRequest(UserSearchRequest userSearchRequest) {
        return userRepository.findPageBySearchRequest(userSearchRequest)
                .map(userMapper::toDto);
    }
}
