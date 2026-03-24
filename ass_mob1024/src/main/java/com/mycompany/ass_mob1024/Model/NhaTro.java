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
public class NhaTro implements Serializable{

    private int maNT;
    private int maLoai;
    private String tenLoai;
    private int maND;
    private String tenND;
    private int giaTien;
    private double dienTich;
    private String quan;
    private String diaChi;
    private String moTa;
    private String ngayDang;
    private int likeCount;
    private int dislikeCount;
    private double score;

    public NhaTro() {
    }

    public NhaTro(int maLoai, int maND, int giaTien, double dienTich,
            String quan, String diaChi, String moTa) {
        this.maLoai = maLoai;
        this.maND = maND;
        this.giaTien = giaTien;
        this.dienTich = dienTich;
        this.quan = quan;
        this.diaChi = diaChi;
        this.moTa = moTa;
    }

    public String getTenND() {
        return tenND;
    }

    public void setTenND(String tenND) {
        this.tenND = tenND;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.tenLoai = TenLoai;
    }

    public int getMaNT() {
        return maNT;
    }

    public void setMaNT(int maNT) {
        this.maNT = maNT;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public int getMaND() {
        return maND;
    }

    public void setMaND(int maND) {
        this.maND = maND;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
