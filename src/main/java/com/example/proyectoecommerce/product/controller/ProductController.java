package com.example.proyectoecommerce.product.controller;

import com.example.proyectoecommerce.product.dto.DTOProduct;
import com.example.proyectoecommerce.product.model.Product;
import com.example.proyectoecommerce.product.service.api.ProductServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductServiceAPI productServiceAPI;

    @GetMapping(value = "/all")
    public List<DTOProduct> getAll() throws Exception {
        return productServiceAPI.getAll();
    }

    @GetMapping(value = "/allBrench")
    public Set<DTOProduct> getAllBrench() throws Exception {
        return productServiceAPI.getBrench();
    }


    @GetMapping(value = "/getMostSold")
    public List<DTOProduct> getMostSold() throws Exception {
        return productServiceAPI.getMostSold();
    }


    @GetMapping(value = "/find/{id}")
    public DTOProduct find(@PathVariable String id) throws Exception {
        return productServiceAPI.get(id);
    }

    @PostMapping(value = "/save/")
    public ResponseEntity<String> save(@RequestBody Product product) throws Exception {
        productServiceAPI.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(value = "/save/{id}")
    public ResponseEntity<String> saveWithID(@RequestBody Product category, @PathVariable String id) throws Exception {
        if (id == null || id.length() == 0 || id.equals("null")) {
            id = productServiceAPI.save(category);
        } else {
            productServiceAPI.save(category, id);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<DTOProduct> delete(@PathVariable String id) throws Exception {
        DTOProduct category = productServiceAPI.get(id);
        if (category != null) {
            productServiceAPI.delete(id);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @GetMapping(value = "/getProductByCategory/{id}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String id) {
        try {
            List<Product> products = productServiceAPI.getProductsByCategory(id);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProductByBrand/{brand}")
    public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable String brand) {
        try {
            List<Product> products = productServiceAPI.getProductsByBrand(brand);
            if (products.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


//    @GetMapping(value = "/search")
//    public List<DTOProduct> search(@RequestParam String searchTerm) throws Exception {
//        return productServiceAPI.searchProducts(searchTerm);
//    }
//


}
