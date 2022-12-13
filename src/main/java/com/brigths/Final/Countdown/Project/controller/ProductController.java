package com.brigths.Final.Countdown.Project.controller;

import com.brigths.Final.Countdown.Project.model.Product;
import com.brigths.Final.Countdown.Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductService productService;
//    private CategoryService categoryService; adding for further implementation with category part

    @Autowired
    public ProductController(ProductService productService/*,CategoryService categoryService*/) {
        this.productService = productService;
//        this.categoryService = categoryService;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        try{
            Product newProduct= productService.saveProduct(new Product(product.getName(),product.getPrice(),product.getWeight()
            ,product.getSummary(),product.getDescription(),product.getImageName(), product.getCategory()));

            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String name){

        try {
            List<Product> products = new ArrayList<>();

            if(name == null) {
                products = productService.getAllProducts();
            } else {
                products = productService.getProductByName(name);
            }

            if(products.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products,HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") long productId){
        Product product = productService.getProductById(productId);

        if(product != null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping ("products/{productId}")
    public ResponseEntity<Product> updateProductById (@PathVariable("productId") long productId, @RequestBody Product product){

        Product updateProduct = productService.updateProductById(productId,product);

        if(updateProduct != null){
            return new ResponseEntity<>(productService.saveProduct(updateProduct),HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("products/{productId}")
    public ResponseEntity<Product> deleteProductById (@PathVariable ("productId") long productId){
        try {
            productService.deleteProductById(productId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
