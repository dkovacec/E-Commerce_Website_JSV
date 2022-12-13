package com.brigths.Final.Countdown.Project.dto;

import jakarta.validation.constraints.NotNull;

public class AddToCartDto {

    private Long id;

    @NotNull
    private Long productId;

    @NotNull
    private Integer quantity;

    public AddToCartDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
