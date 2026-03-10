/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.ImportedProduct;
import model.Product;
import service.ProductService;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        ProductService ps = new ProductService();
        ps.add(new Product("P1","Bánh",10));
        ps.add(new Product("P2","Sữa",20));
        ps.add(new ImportedProduct("P3","Táo Mỹ",30,0.1,5));
        ps.add(new ImportedProduct("P4","Cam Úc",40,0.15,7));
        ps.add(new Product("P5","Nước",15));
        System.out.println("Danh sách sản phẩm:");
        ps.show();
        System.out.println("Sản phẩm giá cao nhất:");
        System.out.println(ps.maxPrice());
    }
}