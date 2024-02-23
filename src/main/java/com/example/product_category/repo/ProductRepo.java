package com.example.product_category.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product_category.Entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>
{
	
}
