package com.example.proyectoecommerce.controller.user;

import com.example.proyectoecommerce.model.user.DTOUser;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private  Firestore db;

    @Autowired
    public UserController(FirebaseApp firebaseApp) {
        this.db = FirestoreClient.getFirestore(firebaseApp);
    }
    @PostMapping
    public String createUser(@RequestBody DTOUser user) throws Exception {
        DocumentReference newUserRef = db.collection("users").document(); // sin argumentos, genera un ID auto
        ApiFuture<WriteResult> result = newUserRef.set(user);
        result.get();
        return "User created successfully with ID: " + newUserRef.getId();
    }

    @GetMapping
    public List<DTOUser> getUsers()  {
        CollectionReference users = db.collection("users");
        List<DTOUser> userList = new ArrayList<>();
        users.listDocuments().forEach(userRef -> {
            try {
                DocumentSnapshot documentSnapshot = userRef.get().get();
                if (documentSnapshot.exists()) {
                    userList.add(documentSnapshot.toObject(DTOUser.class));
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        return userList;
    }

    @GetMapping("/{userId}")
    public DTOUser getUserById(@PathVariable String userId) throws ExecutionException, InterruptedException {
        DocumentSnapshot documentSnapshot = db.collection("users").document(userId).get().get();
        if (documentSnapshot.exists()) {
            return documentSnapshot.toObject(DTOUser.class);
        }
        return null;
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable String userId, @RequestBody DTOUser user) {
        CollectionReference users = db.collection("users");
        users.document(userId).set(user);
        return "User updated successfully";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        db.collection("users").document(userId).delete();
        return "User deleted successfully";
    }
}
