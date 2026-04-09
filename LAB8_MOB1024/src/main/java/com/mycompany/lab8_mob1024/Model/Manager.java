/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8_mob1024.Model;

/**
 *
 * @author LENOVO
 */


public class Manager extends Employee {

    public Manager(double salary) {
        super(salary);
    }

    @Override
    public double getSalary() {
        return salary * 2; 
    }

    @Override
    public double getSalaryNew() {
        return salary * 2;
    }
}