package com.example.bankflow.entity.user;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "phone")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Phone {

    @Id
    @UuidGenerator
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String number;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
