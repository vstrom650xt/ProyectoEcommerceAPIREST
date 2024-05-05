package com.example.proyectoecommerce.categories.service.api;

import com.example.proyectoecommerce.categories.dto.DTOCategory;
import com.example.proyectoecommerce.categories.model.Category;
import com.example.proyectoecommerce.commons.GenericServiceAPI;
import com.example.proyectoecommerce.product.model.Product;
import com.example.proyectoecommerce.user.model.User;
import com.example.proyectoecommerce.user.dto.DTOUser;

import java.util.List;
import java.util.concurrent.ExecutionException;


public interface CategoryServiceAPI extends GenericServiceAPI<Category, DTOCategory> {

}