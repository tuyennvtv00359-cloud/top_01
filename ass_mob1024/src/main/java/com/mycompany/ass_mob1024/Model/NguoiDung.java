/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ass_mob1024.Model;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class NguoiDung implements Serializable{
    private int maND;
    private String tenND;
    private String gioiTinh;
    private String dienThoai;
    private String email;
    private String diaChi;
    private String quan;

    public NguoiDung() {
    }

    public NguoiDung(int maND, String tenND, String gioiTinh,
            String dienThoai, String email,
            String diaChi, String quan) {

        this.maND = maND;
        this.tenND = tenND;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.quan = quan;
    }
    
    public NguoiDung( String tenND, String gioiTinh,
            String dienThoai, String email,
            String diaChi, String quan) {

        this.tenND = tenND;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.quan = quan;
    }

    public int getMaND() {
        return maND;
    }

    public void setMaND(int maND) {
        this.maND = maND;
    }

    public String getTenND() {
        return tenND;
    }

    public void setTenND(String tenND) {
        this.tenND = tenND;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }
}
