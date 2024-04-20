package com.example.proyectoecommerce.user.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String name;
    private String email;
    private String address;
    private String password;
    private Date creationDate;
    private Date modifedDate;


}