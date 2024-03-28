package com.example.bankflow.api.dto.user;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;



import static com.example.bankflow.api.error.ApiErrorMessage.BAD_REQUEST_AMOUNT;
import static com.example.bankflow.api.error.ApiErrorMessage.BAD_REQUEST_PASSWORD;

@Getter
@Setter
public class UserCreateRequest {

    @NotEmpty
    private String login;

    @NotEmpty
    @Size(min = 6, message = BAD_REQUEST_PASSWORD)
    private String password;

    @NotNull
    @Min(value = 1, message = BAD_REQUEST_AMOUNT)
    private BigDecimal amount;

    @NotEmpty
    private String phone;

    @Email
    private String email;

    @Past
    private LocalDate birthDate;

    @NotEmpty
    private String fullName;

}
