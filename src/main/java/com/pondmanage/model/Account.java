package com.pondmanage.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String address;
    private String phoneNumber;
}
