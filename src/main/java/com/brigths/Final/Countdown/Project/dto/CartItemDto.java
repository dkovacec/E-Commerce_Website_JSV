package com.brigths.Final.Countdown.Project.dto;

import com.brigths.Final.Countdown.Project.model.Cart;
import com.brigths.Final.Countdown.Project.model.Product;

public class CartItemDto {
    private Long id;
    private Integer quantity;
    private Product product;

    public CartItemDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CartItemDto(Cart cart) {
        this.id = cart.getId();
        this.quantity = cart.getQuantity();
        this.setProduct(cart.getProduct());
    }
}
