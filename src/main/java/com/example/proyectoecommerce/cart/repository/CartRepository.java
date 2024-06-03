package com.example.proyectoecommerce.cart.repository;

import com.example.proyectoecommerce.cart.dto.DTOCategory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public interface CategoryRepository {
    DTOCategory createCategory(DTOCategory user);

    List<DTOCategory> getAllUsers() throws InterruptedException, ExecutionException;
    DTOCategory getUserById(String id) throws InterruptedException, ExecutionException;
    DTOCategory updateUser(String id, DTOCategory user) throws InterruptedException, ExecutionException;
    void deleteUser(String id) throws InterruptedException, ExecutionException;
}