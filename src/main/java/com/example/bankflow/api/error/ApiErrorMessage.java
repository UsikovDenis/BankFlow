package com.example.bankflow.api.error;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiErrorMessage {

    public static final String BAD_REQUEST_PHONE = "Такой телефон уже существует";
    public static final String BAD_REQUEST_EMAIL = "Такой email уже существует";

    public static final String BAD_REQUEST_PASSWORD = "Пароль должен содержать не менее 6 знаков";
    public static final String BAD_REQUEST_AMOUNT = "Сумма должна быть больше 0";





}
