/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Product {
    private String id;
    private String name;
    private double basePrice;
    public Product(String id, String name, double basePrice) {
        setId(id);
        this.name = name;
        setBasePrice(basePrice);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        if(id == null || id.isEmpty())
            throw new IllegalArgumentException("ID không được rỗng");
        this.id = id;
    }
    public double getBasePrice() {
        return basePrice;
    }
    public void setBasePrice(double basePrice) {
        if(basePrice < 0)
            throw new IllegalArgumentException("Giá phải >= 0");
        this.basePrice = basePrice;
    }
    public double finalPrice(){
        return basePrice;
    }
    public String toString(){
        return id + " - " + name + " - " + finalPrice();
    }
}
