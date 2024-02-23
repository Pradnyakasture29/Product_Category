package com.example.product_category.Service;

import java.util.List;

import com.example.product_category.Entity.Category;

public interface CategoryService 
{
    public List<Category> getAllCategories();

    public Category getCategoryById(Long id);

    public Category createCategory(Category category);

    public Category updateCategory(Long id, Category categoryDetails);

    public void deleteCategory(Long id);
    
}

    
    

