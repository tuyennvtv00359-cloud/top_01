/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Employee {
    private String id;
    private String name;
    private double basicSalary;
    public Employee(String id,String name,double basicSalary){
        this.id=id;
        this.name=name;
        this.basicSalary=basicSalary;
    }
    public double income(){
        return basicSalary;
    }
    public String toString(){
        return id+" - "+name+" - "+income();
    }
}
