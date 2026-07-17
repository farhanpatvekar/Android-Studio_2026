package com.example.assignment_recyclerview;

import java.io.Serializable;

public class Product implements Serializable {

    private int productPrice, productImage;
    private String productName;

    Product (String pName, int pPrice, int pImage) {
        this.productName = pName;
        this.productPrice = pPrice;
        this.productImage = pImage;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productPrice=" + productPrice +
                ", productName='" + productName + '\'' +
                ", productImage='" + productImage + '\'' +
                '}';
    }
}
