package com.company.model;

import com.company.Controller.ProductDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private  final ProductDaoImpl productDaoImpl = new ProductDaoImpl();
    public void createProduct(Product product){
        productDaoImpl.createProduct(product);
    }
    public  Product getProductById(int productId){
        return productDaoImpl.getProductById(productId);
    }
    public ArrayList<Product> getAllProducts() {
        return productDaoImpl.getAllProducts();
    }
    public void updateProductById1( int id,String ordernumber, String description){
        productDaoImpl.updateProductById1(id,ordernumber,description);
    }
    public void updateProductById2(int id, Double productWidth, Double productDepth, Double productHeight, Double productWeight){
        productDaoImpl.updateProductById2(id, productWidth, productDepth, productHeight, productWeight);
    }
    public void updateProductById3(int id, Double productPrice){
        productDaoImpl.updateProductById3(id,productPrice);
    }
    public void deleteProductById(int id){
        productDaoImpl.deleteProductById(id);
    }
}
