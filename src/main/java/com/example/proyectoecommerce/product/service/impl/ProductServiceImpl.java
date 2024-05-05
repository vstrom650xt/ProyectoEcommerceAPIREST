package com.example.proyectoecommerce.product.service.impl;

import com.example.proyectoecommerce.commons.GenericServiceImpl;
import com.example.proyectoecommerce.product.dto.DTOProduct;
import com.example.proyectoecommerce.product.model.Product;
import com.example.proyectoecommerce.product.service.api.ProductServiceAPI;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, DTOProduct> implements ProductServiceAPI {


    @Autowired
    private Firestore firestore;

    public ProductServiceImpl() {
        super(DTOProduct.class);
    }

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("productos");
    }

    @Override
    public Set<DTOProduct> getBrench() throws ExecutionException, InterruptedException {
        CollectionReference collection = firestore.collection("productos");
        ApiFuture<QuerySnapshot> querySnapshot = collection.get();
        QuerySnapshot snapshot = querySnapshot.get();
        Set<DTOProduct> products = new HashSet<>();

        for (DocumentSnapshot document : snapshot.getDocuments()) {
            String marca = document.getString("marca");
            DTOProduct dtoProduct = new DTOProduct(marca);
            products.add(dtoProduct);
        }

        return products;
    }

    @Override
    public List<DTOProduct> getMostSold() throws ExecutionException, InterruptedException {
        CollectionReference collection = firestore.collection("productos");

        ApiFuture<QuerySnapshot> querySnapshot = collection.get();
        QuerySnapshot snapshot = querySnapshot.get();
        List<DTOProduct> products = new ArrayList<>();

        for (DocumentSnapshot doc : snapshot.getDocuments()) {
            String id = doc.getString("id");
            String nombre = doc.getString("nombre");
            String url = doc.getString("url");
            double precio = doc.getDouble("precio");
            String descripcion = doc.getString("descripcion");
            boolean masVendido = doc.getBoolean("masVendido");
            String marca = doc.getString("marca");
            String categoria = doc.getString("categoria");

            DTOProduct dtoProduct = new DTOProduct(id, nombre, url, precio, descripcion, masVendido, marca, categoria);
            products.add(dtoProduct);
        }

        return products;
    }

    @Override
    public List<Product> getProductsByCategory(String id) throws ExecutionException, InterruptedException {
        List<Product> products = new ArrayList<>();

        // Realiza una consulta a Firestore para obtener los productos de una categoría específica
        ApiFuture<QuerySnapshot> query = firestore.collection("productos")
                .whereEqualTo("categoria", id)  // Filtra por la categoría especificada
                .get();

        // Obtiene el resultado de la consulta
        QuerySnapshot querySnapshot = query.get();

        // Itera sobre los documentos devueltos y crea objetos Product
        for (DocumentSnapshot document : querySnapshot.getDocuments()) {
            Product product = document.toObject(Product.class);
            products.add(product);
        }

        return products;
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        List<Product> products = new ArrayList<>();

        // Realiza una consulta a Firestore para obtener los productos de una marca específica
        ApiFuture<QuerySnapshot> query = firestore.collection("productos")
                .whereEqualTo("marca", brand)  // Filtra por la marca especificada
                .get();

        try {
            // Obtiene el resultado de la consulta
            QuerySnapshot querySnapshot = query.get();

            // Itera sobre los documentos devueltos y crea objetos Product
            for (DocumentSnapshot document : querySnapshot.getDocuments()) {
                Product product = document.toObject(Product.class);
                products.add(product);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(); // Manejar la excepción de alguna manera, como registrarla o relanzarla
        }

        return products;
    }


}


//@Override
//public List<DTOProduct> getMostSold() throws ExecutionException, InterruptedException {
//    CollectionReference collection = firestore.collection("productos");
//    Query query = collection.whereEqualTo("masVendido", true);
//    ApiFuture<QuerySnapshot> querySnapshot = query.get();
//
//    List<DTOProduct> products = new ArrayList<>();
//
//    for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
//        DTOProduct product = document.toObject(DTOProduct.class);
//        products.add(product);
//    }
//
//    return products;
//}