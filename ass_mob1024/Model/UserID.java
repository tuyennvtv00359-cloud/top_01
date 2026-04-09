/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ass_mob1024.Model;

import java.util.regex.Pattern;

/**
 *
 * @author PC
 */
public record UserID(int id, String dt) {
    private static final Pattern PHONE_PATTERN = Pattern.compile("^0\\d{9}$");
    public UserID {
        if (id < 0) {
            throw new IllegalArgumentException("ID không thể âm");
        }
        if (!PHONE_PATTERN.matcher(dt).matches()) {
            throw new IllegalArgumentException("Số điện thoại không hợp lệ");  
        }
    }
}
