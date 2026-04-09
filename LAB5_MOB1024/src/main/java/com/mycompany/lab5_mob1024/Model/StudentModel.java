/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_mob1024.Model;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class StudentModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private double gpa;
    public StudentModel() {}

    public StudentModel(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return "Student: " + "ID: " + id + "Name: " + name + "GPA: " + gpa; 
    }
}
