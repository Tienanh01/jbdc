package com.company.Controller;

import com.company.model.Product;

import java.util.ArrayList;

public interface ProductDAO {
    public int createProduct(Product product);
    public Product getProductById(int productId);
    public ArrayList<Product> getAllProducts();
    public void updateProduct(Product product);
    public void deleteProduct(int productId);
    public void updateProductById1(int id,String ordernumber, String description);
    public void updateProductById2(int id,Double productWidth,Double productDepth,Double productHeight,Double productWeight );
    public void updateProductById3(int id,Double productPrice);
    public void deleteProductById(int id);

}
