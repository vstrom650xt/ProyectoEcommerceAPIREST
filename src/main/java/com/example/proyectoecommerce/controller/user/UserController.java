package com.example.proyectoecommerce.controller.user;

import com.example.proyectoecommerce.model.user.User;
import com.example.proyectoecommerce.service.user.api.UserServiceAPI;

import com.example.proyectoecommerce.user.dto.DTOUser;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserServiceAPI userServiceAPI;

    @GetMapping(value = "/all")
    public List<DTOUser> getAll() throws Exception {
        return userServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public DTOUser find(@PathVariable String id) throws Exception {
        return userServiceAPI.get(id);
    }

    @PostMapping(value = "/save/")
    public ResponseEntity<String> save(@RequestBody User user) throws Exception {
        userServiceAPI.save(user);
        return new ResponseEntity<String>(HttpStatus.OK);
    }


    @PostMapping(value = "/save/{id}")
    public ResponseEntity<String> saveWithID(@RequestBody User user, @PathVariable String id) throws Exception {
        if (id == null || id.length() == 0 || id.equals("null")) {
            id = userServiceAPI.save(user);
        } else {
            userServiceAPI.save(user, id);
        }
        return new ResponseEntity<String>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<DTOUser> delete(@PathVariable String id) throws Exception {
        DTOUser persona = userServiceAPI.get(id);
        if (persona != null) {
            userServiceAPI.delete(id);
        } else {
            return new ResponseEntity<DTOUser>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<DTOUser>(persona, HttpStatus.OK);
    }
}
