package com.company.View;

import com.company.Controller.ProductDAO;
import com.company.Controller.ProductDaoImpl;
import com.company.model.Product;
import com.company.model.ProductService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductView {
    public  void main() {
        ProductDaoImpl productDao = new ProductDaoImpl();
        ProductService service = new ProductService();
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println();
        do {
            System.out.println("--------------------------MENU-------------------------------");
            System.out.println("1: create a new product ");
            System.out.println("2: Get product by id");
            System.out.println("3: Get all product");
            System.out.println("4: Update product");
            System.out.println("5: Delete product");
            System.out.println("6: Quit");
            System.out.println("Chọn một số để thực hiện lựa chọn của bạn? ");
            choice = sc.nextInt();

            switch (choice){
                case 1: {
                    System.out.println("Tạo sản phẩm mới  ");

                    System.out.println("Nhập số thứ tự sản phẩm");
                    sc.nextLine();
                        String sothutu = sc.nextLine();
                    System.out.println("Nhập mô tả sản phẩm : ");
                    String mota = sc.nextLine();
                    System.out.println("Nhập chiều rộng sản phẩm : ");
                    double chieurong = sc.nextDouble();
                    System.out.println("Nhập độ sâu sản phẩm : ");
                    double chieusau = sc.nextDouble();
                    System.out.println("Nhập chiều cao sản phẩm : ");
                    double chieucao = sc.nextDouble();
                    System.out.println("Nhập cân nặng sản phẩm : ");
                    double cannang = sc.nextDouble();
                    System.out.println("Nhập giá sản phẩm  : ");
                    double gia = sc.nextDouble();
                    Product product = new Product(sothutu,mota,chieurong,chieusau,chieucao,cannang,gia);
                    ProductDAO productDAO1 = new ProductDaoImpl();
                    int index = productDAO1.createProduct(product);
                    if(index > 0){
                        System.out.println("success");
                    }
                    System.out.println(product.toString());
                    break;}
                case 2: {
                    System.out.println("Enter a productID");
                    int productId = sc.nextInt();

                    Product product2 = productDao.getProductById(productId);
                    System.out.println("Thông tin sản phẩn có id : " + productId + " là");
                    System.out.println(product2.toString());
                    break;
                }
                case 3: {
                    System.out.println("Danh sách product ");
                    for (Product p: productDao.getAllProducts()) {
                        System.out.println(p.toString());
                    }
                    break;
                }
                case 4:{
                    ArrayList<Product> list = productDao.getAllProducts();
                    System.out.println("Nhap ip product cần update ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    int count = 0;
                    for (Product p:  list) {
                        if (p.getProductId() == id){
                            count++;
                        }
                    }
                    if(count == 0){
                        System.out.println("Không có id bạn nhập ");
                        continue;
                    }else{

                            String chon;
                            do {
                                System.out.println("a : Update số thứ tự và mô tả theo id");
                                System.out.println("b : Update kích thước sản phẩm theo id");
                                System.out.println("c : Update giá sản phẩm theo id");
                                System.out.println("Nhập exit để thoát");
                                System.out.println("Bạn chọn : ");
                                    chon = sc.nextLine();
                                switch (chon){
                                    case "a" : {
                                        System.out.println("Nhập số thứ tự ");
                                    String sothutu = sc.nextLine();
                                    System.out.println("Nhập mô tả cần thay đổi ");
                                    String mota = sc.nextLine();
                                    service.updateProductById1(id,sothutu,mota);
                                    break;
                                    }
                                    case "b":{
                                        System.out.println("Nhập chiều rộng sản phẩm : ");
                                        double chieurong = sc.nextDouble();
                                        System.out.println("Nhập độ sâu sản phẩm : ");
                                        double chieusau = sc.nextDouble();
                                        System.out.println("Nhập chiều cao sản phẩm : ");
                                        double chieucao = sc.nextDouble();
                                        System.out.println("Nhập cân nặng sản phẩm : ");
                                        double cannang = sc.nextDouble();

                                        service.updateProductById2(id,chieurong,chieusau,chieucao,cannang);
                                        break;
                                    }
                                    case "c" : {
                                        System.out.println("Nhập giá sản phẩm  : ");
                                        double gia = sc.nextDouble();
                                        service.updateProductById3(id,gia);
                                        break;
                                    }
                                    default:
                                        System.out.println("vui lòng nhập lựa chọn khác");
                                        break;

                                }
                            }while(!chon.equals("exit"));




                    }

                }
                case 5:{
                    ArrayList<Product> list = productDao.getAllProducts();
                    System.out.println("Nhap ip product cần xóa ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    int count = 0;
                    for (Product p:  list) {
                        if (p.getProductId() == id){
                            count++;
                        }
                    }
                    if(count == 0){
                        System.out.println("Không có id bạn nhập ");
                        continue;
                    }else{
                        service.deleteProductById(id);
                    }
                    break;
                }
            }
        }while(choice!=6);
    }
}
