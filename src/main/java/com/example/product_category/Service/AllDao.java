package com.example.product_category.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_category.Entity.Category;
import com.example.product_category.Entity.Product;
import com.example.product_category.repo.CategoryRepo;
import com.example.product_category.repo.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AllDao implements CategoryService,ProductService
{
    @Autowired
    private CategoryRepo categoryrepo;

    @Autowired
    private ProductRepo productrepo;
    
    public Product getProductWithCategory(Long id) 
    {
        Optional<Product> productOptional = productrepo.findById(id);
        if (productOptional.isPresent())
        {
            return productOptional.get();
        }
        throw new EntityNotFoundException("Product not found with id: " + id);
    }
    
    @Override
    public List<Category> getAllCategories() 
    {
        return categoryrepo.findAll();
    }

    @Override
    public Category getCategoryById(Long id)
    {
        return categoryrepo.findById(id).orElseThrow();
    }

    @Override
    public Category createCategory(Category category) 
    {
        return categoryrepo.save(category);
    }
    
    @Override
    public void deleteCategory(Long id) 
    {
        Category category = getCategoryById(id);
        categoryrepo.delete(category);
    }

    @Override
    public List<Product> getAllProducts()
    {
        return productrepo.findAll();
    }

    @Override
    public Product getProductById(Long id)
    {
        return productrepo.findById(id).orElseThrow();
    }

    @Override
    public Product createProduct(Product product)
    {
        return productrepo.save(product);
    }
    
    @Override
    public Product updateProduct(Long id, Product newProduct) 
    {
        Optional<Product> productOptional = productrepo.findById(id);
        if (productOptional.isPresent())
        {
            Product existingProduct = productOptional.get();
            existingProduct.setName(newProduct.getName());
            existingProduct.setPrice(newProduct.getPrice());
            
            return productrepo.save(existingProduct);
        } 
        else 
        {
            return null;
        }
    }

    @Override
    public void deleteProduct(Long id)
    {
        Product product = getProductById(id);
        productrepo.delete(product);
    }
    
    @Transactional
    @Override
    public Category updateCategory(Long id, Category newCategory) 
    {
        Category existingCategory = categoryrepo.findById(newCategory.getId()).orElse(null);
        if (existingCategory != null) 
        {
            existingCategory.setName(newCategory.getName());
            
            return categoryrepo.save(existingCategory);
        } 
        else 
        { 
            return null;
        }
    }
}
