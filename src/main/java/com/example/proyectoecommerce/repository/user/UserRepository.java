package com.example.proyectoecommerce.repository.user;

import com.example.proyectoecommerce.model.user.DTOUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public interface UserRepository {
    List<DTOUser> getAllUsers() throws InterruptedException, ExecutionException;
    DTOUser getUserById(String id) throws InterruptedException, ExecutionException;
    DTOUser createUser(DTOUser user) throws InterruptedException, ExecutionException;
    DTOUser updateUser(String id, DTOUser user) throws InterruptedException, ExecutionException;
    void deleteUser(String id) throws InterruptedException, ExecutionException;
}