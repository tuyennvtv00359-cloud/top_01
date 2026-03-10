/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class PartTimeEmployee extends Employee{

    private double workingHours;
    private double hourlyRate;
    public PartTimeEmployee(String id,String name,double hours,double rate){
        super(id,name,0);
        this.workingHours=hours;
        this.hourlyRate=rate;
    }
    @Override
    public double income(){
        return workingHours*hourlyRate;
    }
}