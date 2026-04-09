/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6_mob1024.Model;

/**
 *
 * @author LENOVO
 */

public class Student {
    private int studentId;
    private String studentName;
    private String gender;
    private Float gpa;

    public Student() {
    }

    public Student(int studentId, String studentName, String gender, Float gpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.gpa = gpa;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "\nEmployee: " + "ID: " + studentId + "Name: " + studentName + "Gender: " + gender + "GPA: " + gpa;
    }
}