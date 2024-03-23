package com.example.proyectoecommerce.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Configuration
public class FirebaseConfig {
//    private static FirebaseApp firebaseApp;

    @Bean
    public Firestore firestore() throws Exception {

        FileInputStream serviceAccount = new FileInputStream("./ecommerce-176bc-firebase-adminsdk-q14vx-1b03aed55e.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();

        FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);

        return FirestoreClient.getFirestore(firebaseApp);

    }
}
