package com.brigths.Final.Countdown.Project.dto;

import com.brigths.Final.Countdown.Project.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;

public class ProductDTO {

    private Long id;
    private String name;
    private double price;
    private double weight;
    private String summary;
    private String description;
    private String imageName;
    private int categoryId;

    public ProductDTO() {
    }


    public ProductDTO fromEntity(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.id = product.getId();
        productDTO.name = product.getName();
        productDTO.price = product.getPrice();
        productDTO.weight = product.getWeight();
        productDTO.summary = product.getSummary();
        productDTO.description = product.getDescription();
        productDTO.imageName = product.getImageName();
        productDTO.categoryId = product.getCategory().getId();
        return productDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
