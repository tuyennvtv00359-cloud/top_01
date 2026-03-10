/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class FullTimeEmployee extends Employee{
    private double bonus;
    private double penalty;
    public FullTimeEmployee(String id,String name,double salary,double bonus,double penalty){
        super(id,name,salary);
        this.bonus=bonus;
        this.penalty=penalty;
    }
    @Override
    public double income(){
        return super.income()+bonus-penalty;
    }
}
