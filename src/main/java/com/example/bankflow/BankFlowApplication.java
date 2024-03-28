package com.example.bankflow;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BankFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankFlowApplication.class, args);
    }

}
