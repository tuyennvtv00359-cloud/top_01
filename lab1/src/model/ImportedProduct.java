/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class ImportedProduct extends Product {
    private double importTaxRate;
    private double shippingFee;
    public ImportedProduct(String id,String name,double basePrice,
            double importTaxRate,double shippingFee){
        super(id,name,basePrice);
        this.importTaxRate = importTaxRate;
        this.shippingFee = shippingFee;
    }
    @Override
    public double finalPrice(){
        return getBasePrice() + getBasePrice()*importTaxRate + shippingFee;
    }
}
