package com.brigths.Final.Countdown.Project.service;

import com.brigths.Final.Countdown.Project.model.Product;
import com.brigths.Final.Countdown.Project.repository.CategoryRepository;
import com.brigths.Final.Countdown.Project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product saveProduct(Product product) {

        Product newProduct = productRepository.save(product);

        return newProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {

        Optional<Product> productData = productRepository.findById(id);

        if(productData.isPresent()){
            return productData.get();
        }else {
            return null;
        }


    }

    @Override
    public Product updateProductById(long id, Product product) {

        Product productData = getProductById(id);

        if(productData != null){
            productData.setName(product.getName());
            productData.setPrice(product.getPrice());
            productData.setWeight(product.getWeight());
            productData.setSummary(product.getSummary());
            productData.setDescription(product.getDescription());
            productData.setImageName(product.getImageName());
            productData.setCategory(product.getCategory());

            return productData;
        }

        return null;
    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);

    }

    @Override
    public boolean existsProductById(long id) {
        return existsProductById(id);
    }

    @Override
    public List<Product> getProductsByCategoryId(long categoryId) {
        return productRepository.findTutorialsByCategoryId(categoryId);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
}
