package com.example.product_category.Controller;

import com.example.product_category.Entity.Category;
import com.example.product_category.Service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryControl 
{
    @Autowired
    private CategoryService categoryservice;
    
    @PostMapping
    public Category createCategory(@RequestBody Category category)  
    {
    Long l=category.getId();
    category.setId(l);
    
    return categoryservice.createCategory(category);
    }
    
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() 
    {
        List<Category> categories = categoryservice.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable(value = "id") Long id) 
    {
        return categoryservice.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) 
    {
        Category updatedCategory = categoryservice.updateCategory(id, category);
        if (updatedCategory != null) 
        {
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        } else 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(value = "id") Long id)
    {
    	categoryservice.deleteCategory(id);
        return ResponseEntity.ok().build();
    
    }
}


