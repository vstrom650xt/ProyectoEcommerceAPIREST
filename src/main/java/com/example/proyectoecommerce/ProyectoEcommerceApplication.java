package com.example.proyectoecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.File;
import java.util.Objects;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})public class ProyectoEcommerceApplication {

    public static void main(String[] args) {
//        ClassLoader classLoader = ProyectoEcommerceApplication.class.getClassLoader();
//        File file = new File(Objects.requireNonNull(classLoader.getResource("ecommerce-176bc-firebase-adminsdk-q14vx-1b03aed55e.json")).getParentFile());
        SpringApplication.run(ProyectoEcommerceApplication.class, args);
    }

}
