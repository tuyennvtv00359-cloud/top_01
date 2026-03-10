/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.Product;

/**
 *
 * @author admin
 */
public class ProductService {
    private ArrayList<Product> list = new ArrayList<>();
    public void add(Product p){
        list.add(p);
    }
    public void show(){
        for(Product p:list){
            System.out.println(p);
        }
    }
    public Product maxPrice(){
        Product max=list.get(0);
        for(Product p:list){
            if(p.finalPrice()>max.finalPrice())
                max=p;
        }
        return max;
    }
}
