package com.example.proyectoecommerce.cart.service.impl;

import com.example.proyectoecommerce.cart.dto.DTOCategory;
import com.example.proyectoecommerce.cart.model.Category;
import com.example.proyectoecommerce.cart.service.api.CategoryServiceAPI;
import com.example.proyectoecommerce.commons.GenericServiceImpl;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category, DTOCategory> implements CategoryServiceAPI {


   @Autowired
   private Firestore firestore;

    public CategoryServiceImpl() {
        super(DTOCategory.class);
    }

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("categories");
    }




}
