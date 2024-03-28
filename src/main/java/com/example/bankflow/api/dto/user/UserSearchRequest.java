package com.example.bankflow.api.dto.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

@Getter
@Setter
public class UserSearchRequest {

    private String phone;

    private String email;

    private LocalDate birthDate;

    private String fullName;

    @JsonIgnore
    private Pageable pageable;

}
