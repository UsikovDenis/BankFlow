package com.example.bankflow.api.controller.open;

import com.example.bankflow.api.dto.user.UserCreateRequest;
import com.example.bankflow.api.dto.user.UserDto;
import com.example.bankflow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("open/user")
@RequiredArgsConstructor
@Validated
public class OpenUserController {

    private final UserService userService;

    @PostMapping
    public UserDto create(@RequestBody @Validated() UserCreateRequest userCreateRequest) {
        return userService.create(userCreateRequest);
    }


}