package com.company.Controller;

import com.company.model.ConnectToDatabase;
import com.company.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDAO {
    private final Connection conn = ConnectToDatabase.createConnection();
    String PRODUCTORDERNUMBER ;
    String PRODUCTDESCRIPTION;
    private final String SQL_CREATE_PRODUCT = "insert into product (productOrderNumber, productDescription, productWidth, productDepth, productHeight, productWeight, productPrice) values(?,?,?,?,?,?,?)";
    private final String SQL_GET_PRODUCT_BY_ID = "slect * from product where productid = ?";
    private final String SQL_GET_ALL_PRODUCTS ="select * from product";

    // update
    private final String SQL_UPDATE_PRODUCT_BY_ID_1 = "update product set productordernumber =  ? , productdescription = ? where productid = ?";
    private final String SQL_UPDATE_PRODUCT_BY_ID_2 = "update product set PRODUCTWIDTH = ? ,PRODUCTDEPTH = ? , PRODUCTHEIGHT = ?, PRODUCTWEIGHT = ? where PRODUCTID = ?";
    private final String SQL_UPDATE_PRODUCT_BY_ID_3 = "update product set productprice =  ? where productid = ?";

    private final String SQL_UPDATE_PRODUCT ="update product set productOrderNumber = ?, productDescription = ?, productWidth = ?, productDepth = ?, productHeight = ?, productWeight = ?, productPrice = ?";
    private final String SQL_DELETE_PRODUCT = "DELETE from product where productid = ?";
    @Override
    public int createProduct(Product product) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_CREATE_PRODUCT)
        ) {
            pstmt.setString(1,product.getProductOderNumber());
            pstmt.setString(2, product.getProductDescription());
            pstmt.setDouble(3,product.getProductWith());
            pstmt.setDouble(4,product.getProductDepth());
            pstmt.setDouble(5,product.getProductHeight());
            pstmt.setDouble(6,product.getProductWeight());
            pstmt.setDouble(7, product.getProductPrice());
           row =  pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    return  row;
    }

    @Override
    public Product getProductById(int productId) {

        Product product = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from product where productId = ?");
            pstmt.setInt(1,productId);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
               productId = rs.getInt(1);
                String PRODUCTORDERNUMBER = rs.getString(2);
                String PRODUCTDESCRIPTION = rs.getString(3);
                double PRODUCTWIDTH = rs.getDouble(4);
                double PRODUCTDEPTH = rs.getDouble(5);
                double PRODUCTHEIGHT = rs.getDouble(6);
                double PRODUCTWEIGHT = rs.getDouble(7);
                double PRODUCTPRICE = rs.getDouble(8);

                product = new Product(productId,PRODUCTORDERNUMBER,PRODUCTDESCRIPTION,PRODUCTWIDTH,PRODUCTDEPTH,PRODUCTHEIGHT,PRODUCTWEIGHT,PRODUCTPRICE);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

        @Override
    public ArrayList<Product> getAllProducts() {

        List<Product> list = new ArrayList<Product>();
            try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_ALL_PRODUCTS)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()){

                    list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),
                            rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8) ));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return (ArrayList<Product>) list;
    }

    @Override
    public void updateProduct(Product product) {
    // update theo số thứ tự và mô tả sản phẩm
        // update theo kích thước sản phẩm
        // update theo giá


    }

    @Override
    public void deleteProduct(int productId) {

    }

    @Override
    public void updateProductById1(int id,String ordernumber, String description) {

        try (PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE_PRODUCT_BY_ID_1)) {

                pstm.setString(1,ordernumber);
                pstm.setString(2,description);
                pstm.setInt(3,id);
                int rs = pstm.executeUpdate();
                if(rs!= 0){
                    System.out.println("success");
                }
                else{
                    System.out.println("false");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateProductById2(int id, Double productWidth, Double productDepth, Double productHeight, Double productWeight) {
        try (PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE_PRODUCT_BY_ID_2)) {

            pstm.setDouble(1,productWidth);
            pstm.setDouble(2,productDepth);
            pstm.setDouble(3,productHeight);
            pstm.setDouble(4,productWeight);
            pstm.setInt(5,id);
            int rs = pstm.executeUpdate();
            if(rs!= 0){
                System.out.println("success");
            }
            else{
                System.out.println("false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProductById3(int id, Double productPrice) {
        try (PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE_PRODUCT_BY_ID_3)) {

            pstm.setDouble(1,productPrice);
            pstm.setInt(2,id);
            int rs = pstm.executeUpdate();
            if(rs!= 0){
                System.out.println("success");
            }
            else{
                System.out.println("false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteProductById(int id){
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE_PRODUCT);
            preparedStatement.setInt(1,id);
            int rs = 0;
            rs= preparedStatement.executeUpdate();
            if(rs > 0 ){
                System.out.println("Xóa thành công ");
            }else{
                System.out.println("Xóa thất bại");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//product.setProductId(rs.getInt(1));
//                    product.setProductOderNumber(rs.getString(2));
//                    product.setProductDescription(rs.getString(3));
//                    product.setProductWith(rs.getDouble(4));
//                    product.setProductDepth(rs.getDouble(5));
//                    product.setProductHeight(rs.getDouble(6));
//                    product.setProductWeight(rs.getDouble(7));
//                    product.setProductPrice(rs.getDouble(8));