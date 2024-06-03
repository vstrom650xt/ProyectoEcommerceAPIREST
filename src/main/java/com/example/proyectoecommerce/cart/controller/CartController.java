package com.example.proyectoecommerce.cart.controller;

import com.example.proyectoecommerce.cart.dto.DTOCart;
import com.example.proyectoecommerce.cart.model.Cart;
import com.example.proyectoecommerce.cart.service.api.CartServiceAPI;
import com.example.proyectoecommerce.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class CartController {

    @Autowired
    private CartServiceAPI cartServiceAPI;

    @GetMapping(value = "/all")
    public List<DTOCart> getAll() throws Exception {
        return cartServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public DTOCart find(@PathVariable String id) throws Exception {
        return cartServiceAPI.get(id);
    }

    @PostMapping(value = "/save/")
    public ResponseEntity<String> save(@RequestBody Cart cart) throws Exception {
        cartServiceAPI.save(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(value = "/saveProduct/{id}")
    public ResponseEntity<String> saveWithID(@RequestBody Cart category, @PathVariable String id) throws Exception {
        if (id == null || id.isEmpty() || id.equals("null")) {
            id = cartServiceAPI.save(category);
        } else {
            cartServiceAPI.save(category, id);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<DTOCart> delete(@PathVariable String id) throws Exception {
        DTOCart category = cartServiceAPI.get(id);
        if (category != null) {
            cartServiceAPI.delete(id);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(category, HttpStatus.OK);
    }


//    @PostMapping(value = "/save/{id}")
//    public ResponseEntity<String> addProduct(@RequestBody Product product, @PathVariable String id) throws Exception {
//        if (id == null || id.length() == 0 || id.equals("null")) {
//            // Si el ID es nulo, es un nuevo carrito
//            Cart newCart = new Cart();
//            Map<Product, Integer> productsMap = new HashMap<>();
//            productsMap.put(product, 1); // Agregar el producto al carrito con una cantidad inicial de 1
//            newCart.setProducts(productsMap); // Establecer el mapa de productos en el carrito
//            id = cartServiceAPI.save(newCart); // Guardar el carrito y obtener su ID
//        } else {
//            // Si el ID está presente, es un carrito existente
//            Cart existingCart = cartServiceAPI.get(id);
//            if (existingCart != null) {
//                Map<Product, Integer> productsMap = existingCart.getProducts();
//                // Verificar si el producto ya está en el carrito
//                if (productsMap.containsKey(product)) {
//                    // Si el producto ya está en el carrito, aumentar la cantidad
//                    int quantity = productsMap.get(product);
//                    productsMap.put(product, quantity + 1);
//                } else {
//                    // Si el producto no está en el carrito, agregarlo con una cantidad de 1
//                    productsMap.put(product, 1);
//                }
//                // Guardar el carrito actualizado
//                cartServiceAPI.save(existingCart, id);
//            } else {
//                // Manejar el caso en el que no se encuentre el carrito con el ID proporcionado
//                return new ResponseEntity<>("Cart not found", HttpStatus.NOT_FOUND);
//            }
//        }
//        return new ResponseEntity<>(id, HttpStatus.OK);
//    }

}
