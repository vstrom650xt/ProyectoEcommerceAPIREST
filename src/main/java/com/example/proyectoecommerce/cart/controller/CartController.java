package com.example.proyectoecommerce.cart.controller;

import com.example.proyectoecommerce.cart.dto.DTOCategory;
import com.example.proyectoecommerce.cart.model.Category;
import com.example.proyectoecommerce.cart.service.api.CategoryServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryServiceAPI categoryServiceAPI;

    @GetMapping(value = "/all")
    public List<DTOCategory> getAll() throws Exception {
        return categoryServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public DTOCategory find(@PathVariable String id) throws Exception {
        return categoryServiceAPI.get(id);
    }

    @PostMapping(value = "/save/")
    public ResponseEntity<String> save(@RequestBody Category category) throws Exception {
        categoryServiceAPI.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(value = "/save/{id}")
    public ResponseEntity<String> saveWithID(@RequestBody Category category, @PathVariable String id) throws Exception {
        if (id == null || id.length() == 0 || id.equals("null")) {
            id = categoryServiceAPI.save(category);
        } else {
            categoryServiceAPI.save(category, id);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<DTOCategory> delete(@PathVariable String id) throws Exception {
        DTOCategory category = categoryServiceAPI.get(id);
        if (category != null) {
            categoryServiceAPI.delete(id);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
