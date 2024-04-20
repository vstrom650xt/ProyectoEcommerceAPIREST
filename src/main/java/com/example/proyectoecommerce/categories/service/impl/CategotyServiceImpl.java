package com.example.proyectoecommerce.categories.service.impl;

import com.example.proyectoecommerce.categories.dto.DTOCategory;
import com.example.proyectoecommerce.categories.model.Category;
import com.example.proyectoecommerce.categories.service.api.CategoryServiceAPI;
import com.example.proyectoecommerce.commons.GenericServiceImpl;
import com.example.proyectoecommerce.user.model.User;
import com.example.proyectoecommerce.user.service.api.UserServiceAPI;
import com.example.proyectoecommerce.user.dto.DTOUser;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategotyServiceImpl extends GenericServiceImpl<Category, DTOCategory> implements CategoryServiceAPI {


   @Autowired
   private Firestore firestore;

    public CategotyServiceImpl() {
        super(DTOCategory.class);
    }

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("categorias");
    }
}
