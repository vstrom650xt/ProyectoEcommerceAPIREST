package com.example.proyectoecommerce.categories.service.impl;

import com.example.proyectoecommerce.categories.dto.DTOCategory;
import com.example.proyectoecommerce.categories.model.Category;
import com.example.proyectoecommerce.categories.service.api.CategoryServiceAPI;
import com.example.proyectoecommerce.commons.GenericServiceImpl;
import com.example.proyectoecommerce.product.dto.DTOProduct;
import com.example.proyectoecommerce.product.model.Product;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

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
