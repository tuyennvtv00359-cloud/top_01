/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import enumm.StudentType;

/**
 *
 * @author admin
 */
public class Student {

    private String id;
    private String name;
    private StudentType type;

    public Student(String id, String name, StudentType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public StudentType getType() {
        return type;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + type;
    }
}
