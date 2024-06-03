package com.example.proyectoecommerce.user.model;

import com.example.proyectoecommerce.cart.model.Cart;
import lombok.*;

import java.awt.*;
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
    private Cart cart;


}
