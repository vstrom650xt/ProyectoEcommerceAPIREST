package com.example.proyectoecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.File;
import java.util.Objects;

@SpringBootApplication()
public class ProyectoEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoEcommerceApplication.class, args);
    }

}
