/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8_mob1024.Model;

/**
 *
 * @author LENOVO
 */
public class Employee {
    protected double salary;

    public Employee(double salary) {
        this.salary = salary;
    }

    @Deprecated
    public double getSalary() {
        return salary;
    }

    public double getSalaryNew() {
        return salary;
    }
}
