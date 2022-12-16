package com.brigths.Final.Countdown.Project.service;


import com.brigths.Final.Countdown.Project.dto.ProductDTO;
import com.brigths.Final.Countdown.Project.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct (Product product);

    List<Product> getAllProducts();

    Product getProductById (long id);

    Product updateProductById (long id, ProductDTO productDTO);

    void deleteProductById (long id);

    boolean existsProductById(long id);

    List<Product> getProductsByCategoryId (Integer id);

    List<Product> getProductByName (String name);

}
