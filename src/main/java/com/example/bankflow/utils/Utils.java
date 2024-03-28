package com.example.bankflow.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Locale;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    public static String addPercents(String value) {
        return isNotEmpty(value) ? "%" + value.trim() + "%" : EMPTY;
    }

    public static String addPercentsAndUpper(String value) {
        return addPercents(value).toUpperCase();
    }


}
