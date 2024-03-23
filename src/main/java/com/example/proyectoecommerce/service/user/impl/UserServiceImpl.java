package com.example.proyectoecommerce.service.user.impl;

import com.example.proyectoecommerce.commons.GenericServiceAPI;
import com.example.proyectoecommerce.commons.GenericServiceImpl;
import com.example.proyectoecommerce.model.user.User;
import com.example.proyectoecommerce.service.user.api.UserServiceAPI;
import com.example.proyectoecommerce.user.dto.DTOUser;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, DTOUser> implements UserServiceAPI {


   @Autowired
   private Firestore firestore;

    public UserServiceImpl() {
        super(DTOUser.class);
    }

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("users");
    }
}
