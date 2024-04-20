package com.example.proyectoecommerce.user.repository;

import com.example.proyectoecommerce.user.dto.DTOUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    DTOUser createUser(DTOUser user);

//    List<DTOUser> getAllUsers() throws InterruptedException, ExecutionException;
//    DTOUser getUserById(String id) throws InterruptedException, ExecutionException;
//    DTOUser updateUser(String id, DTOUser user) throws InterruptedException, ExecutionException;
//    void deleteUser(String id) throws InterruptedException, ExecutionException;
}