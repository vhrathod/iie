package com.example.Demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="USER_AUTH_TABLE")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;
    String phoneNumber;
    String otp;
    String name;
    private boolean isActive;
}
