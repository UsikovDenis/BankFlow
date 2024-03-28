package com.example.bankflow.api.controller;

import com.example.bankflow.api.dto.user.UserDto;
import com.example.bankflow.api.dto.user.UserSearchRequest;
import com.example.bankflow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @PostMapping("/{page}/{size}")
    public Page<UserDto> getPageBySearchRequest(
            @PathVariable int page,
            @PathVariable int size,
            @RequestBody UserSearchRequest userSearchRequest
    ) {
        userSearchRequest.setPageable(PageRequest.of(page, size));
        return userService.getPageBySearchRequest(userSearchRequest);
    }


}
