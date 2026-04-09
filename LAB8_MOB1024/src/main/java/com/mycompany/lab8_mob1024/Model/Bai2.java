/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8_mob1024.Model;

/**
 *
 * @author LENOVO
 */
public record Bai2(String id, String name, double gpa) {

    public Bai2 {
        if (gpa < 0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA không hợp lệ!");
        }
    }

    public boolean isScholarshipEligible() {
        return gpa >= 3.2;
    }

    public void display() {
        System.out.println(id + " - " + name + " - GPA: " + gpa);
    }
}
