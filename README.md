#Product and Category Management System
This project aims to develop a RESTful API system using Spring Boot framework, facilitating CRUD (Create, Read, Update, Delete) operations for managing categories and products. The system utilizes a relational database (RDB) for data storage, employing JPA (Java Persistence API) in conjunction with Hibernate for seamless interaction with the database.
1) Category CRUD operation.
   
2) Product CRUD operation.
    
3) Relation between Category-Products should have one-to-many relation. (One category can have multiple products).
  
4) In this project should have Server side pagination.
   
5) While fetching single product details the response should be populated with respective category details.

1) GET all the categories
2) POST - create a new category
3) GET category by Id
4) PUT - update category by id
5) DELETE - Delete category by id
I have done curd operation in this project.


Technologies used:A) Use Spring boot
                  B) Use Rest controller
                  C) Need DB configuration (Use RDB instead of in-memory)
                  D) Use annotation based configuration (Not XML).
                  E) JPA & Hibernate
