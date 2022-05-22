package com.company.model;

public class Product {
    private int productId;
    private String productOderNumber;
    private String productDescription;
    private Double productWith;
    private Double productDepth;
    private Double productHeight;
    private Double productWeight;
    private Double productPrice;

    public Product(int productId, String productOderNumber, String productDescription, Double productWith, Double productDepth, Double productHeight, Double productWeight, Double productPrice) {
        this.productId = productId;
        this.productOderNumber = productOderNumber;
        this.productDescription = productDescription;
        this.productWith = productWith;
        this.productDepth = productDepth;
        this.productHeight = productHeight;
        this.productWeight = productWeight;
        this.productPrice = productPrice;
    }

    public Product(String productOderNumber, String productDescription, Double productWith, Double productDepth, Double productHeight, Double productWeight, Double productPrice) {
        this.productOderNumber = productOderNumber;
        this.productDescription = productDescription;
        this.productWith = productWith;
        this.productDepth = productDepth;
        this.productHeight = productHeight;
        this.productWeight = productWeight;
        this.productPrice = productPrice;
    }

    public Product() {

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductOderNumber() {
        return productOderNumber;
    }

    public void setProductOderNumber(String productOderNumber) {
        this.productOderNumber = productOderNumber;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getProductWith() {
        return productWith;
    }

    public void setProductWith(Double productWith) {
        this.productWith = productWith;
    }

    public Double getProductDepth() {
        return productDepth;
    }

    public void setProductDepth(Double productDepth) {
        this.productDepth = productDepth;
    }

    public Double getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(Double productHeight) {
        this.productHeight = productHeight;
    }

    public Double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(Double productWeight) {
        this.productWeight = productWeight;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productOderNumber='" + productOderNumber + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productWith=" + productWith +
                ", productDepth=" + productDepth +
                ", productHeight=" + productHeight +
                ", productWeight=" + productWeight +
                ", productPrice=" + productPrice +
                '}';
    }
}
