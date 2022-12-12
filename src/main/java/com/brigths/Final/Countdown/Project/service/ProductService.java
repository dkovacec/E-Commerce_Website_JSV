package com.brigths.Final.Countdown.Project.service;


import com.brigths.Final.Countdown.Project.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct (Product product);

    List<Product> getAllProducts();

    Product getProductById (long id);

    Product updateProductById (long id, Product product);

    void deleteProductById (long id);

    boolean existsProductById(long id);

    List<Product> getProductsByCategoryId (long categoryId);

    List<Product> getProductByName (String name);

}
