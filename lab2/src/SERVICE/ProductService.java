/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.Product;
import enumm.ProductCategory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class ProductService {

    List<Product> list = new ArrayList<>();

    public void fakeData(){

        list.add(new Product("P1","Bread",20,ProductCategory.FOOD));
        list.add(new Product("P2","Milk",15,ProductCategory.FOOD));
        list.add(new Product("P3","Laptop",1000,ProductCategory.ELECTRONIC));
        list.add(new Product("P4","Phone",800,ProductCategory.ELECTRONIC));
        list.add(new Product("P5","Shirt",40,ProductCategory.CLOTHING));
        list.add(new Product("P6","Pants",60,ProductCategory.CLOTHING));
        list.add(new Product("P7","Cake",25,ProductCategory.FOOD));
        list.add(new Product("P8","TV",1200,ProductCategory.ELECTRONIC));

    }

    public void showAll(){

        for(Product p:list)
            System.out.println(p);

    }

    public void statistic(){

        Map<ProductCategory,Integer> count = new HashMap<>();
        Map<ProductCategory,Double> total = new HashMap<>();

        for(Product p:list){

            count.put(p.getCategory(),
                    count.getOrDefault(p.getCategory(),0)+1);

            total.put(p.getCategory(),
                    total.getOrDefault(p.getCategory(),0.0)+p.getPrice());
        }

        System.out.println("So luong:");

        for(Map.Entry<ProductCategory,Integer> e:count.entrySet()){
            System.out.println(e.getKey()+" : "+e.getValue());
        }

        System.out.println("Tong gia tri:");

        for(Map.Entry<ProductCategory,Double> e:total.entrySet()){
            System.out.println(e.getKey()+" : "+e.getValue());
        }

    }
}
