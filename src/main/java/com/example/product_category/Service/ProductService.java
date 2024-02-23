package com.example.product_category.Service;

import java.util.List;

import com.example.product_category.Entity.Product;

public interface ProductService 
{
    public List<Product> getAllProducts();

    public Product getProductById(Long id);

    public Product createProduct(Product product);

    public Product updateProduct(Long id, Product productDetails);

    public void deleteProduct(Long id);

	public Product getProductWithCategory(Long id);
}
