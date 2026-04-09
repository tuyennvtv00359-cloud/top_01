/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ass_mob1024.Model;

/**
 *
 * @author PC
 */
public enum TrangThai {

    LIKE("LIKE"),
    DISLIKE("DISLIKE");

    private final String value;

    TrangThai(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
