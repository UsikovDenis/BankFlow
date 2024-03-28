package com.example.bankflow.api.dto.user;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static com.example.bankflow.api.error.ApiErrorMessage.BAD_REQUEST_AMOUNT;
import static com.example.bankflow.api.error.ApiErrorMessage.BAD_REQUEST_PASSWORD;

@Getter
@Setter
public class UserDto {

    private UUID id;

    @NotEmpty
    private String login;

    @NotNull
    @Positive(message = BAD_REQUEST_AMOUNT)
    private BigDecimal amount;

    @NotEmpty
    private List<String> phones;

    @NotEmpty
    private List<String> emails;

    @Past
    private LocalDate birthDate;

    @NotEmpty
    private String fullName;

}
