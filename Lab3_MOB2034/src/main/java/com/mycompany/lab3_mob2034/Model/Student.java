/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3_mob2034.Model;

/**
 *
 * @author LENOVO
 */
public class Student {

    private int id;
    private String name;
    private StudentType type;
    private float gpa;

    public Student(int id, String name, StudentType type, float gpa) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.gpa = gpa;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentType getType() {
        return type;
    }

    public void setType(StudentType type) {
        this.type = type;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nTên: " + name + "\nType: " + type + "\nĐiểm: " + gpa + "\n";
    }

}
