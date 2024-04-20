package com.example.proyectoecommerce.user.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString


public class DTOUser {

    private String id;
    private String name;
    private String email;
    private String address;
    private String password;
    private Date creationDate;
    private Date modifedDate;




}
