package com.example.bankflow.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "email")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Email {

    @Id
    @UuidGenerator
    @GeneratedValue
    private UUID id;


    @Column(nullable = false, unique = true)
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
