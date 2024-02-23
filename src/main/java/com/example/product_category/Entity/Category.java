package com.example.product_category.Entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table( name = "category")
public class Category 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Product> products;

    public Category() 
    {
    }

    public Category(Category category) 
    {
    	this.id=category.getId();
        this.name = category.getName();
    }
    
    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Product> getProducts() 
    {
        return products;
    }

    public void setProducts(List<Product> products) 
    {
        this.products = products;
    }

	@Override
	public String toString() 
	{
		return "Category [id=" + id + ", name=" + name + ", products=" + products + "]";
	}
}


