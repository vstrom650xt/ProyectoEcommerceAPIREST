package com.example.proyectoecommerce.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Configuration
public class FirebaseConfig {
    @Bean
    public FirebaseApp initialization(){
        System.out.println("Firebase inicializado correctamente.");

        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("./ecommerce-176bc-firebase-adminsdk-q14vx-1b03aed55e.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://ecommerce-176bc-default-rtdb.europe-west1.firebasedatabase.app")
                    .build();
            return FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
