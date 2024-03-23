package com.example.proyectoecommerce.controller.user;

import com.example.proyectoecommerce.service.user.api.UserServiceAPI;

import com.example.proyectoecommerce.user.dto.DTOUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private  UserServiceAPI userServiceAPI;

    @GetMapping(value = "/all")
    public List<DTOUser> getAll() throws Exception {
        return userServiceAPI.getAll();
    }

}
