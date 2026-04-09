/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ass_mob1024.Model;

/**
 *
 * @author ADMIN
 */
import java.io.Serializable;

public class DanhGia implements Serializable{
    private int maDG;
    private String tenND;
    private int maND;
    private int maNT;
    private TrangThai trangThai;
    private String noiDung;
    private String ngayDanhGia;

    public DanhGia() {
    }

    public DanhGia(int maND, int maNT, TrangThai trangThai, String noiDung) {
        this.maND = maND;
        this.maNT = maNT;
        this.trangThai = trangThai;
        this.noiDung = noiDung;
    }

    public int getMaDG() {
        return maDG;
    }

    public void setMaDG(int maDG) {
        this.maDG = maDG;
    }

    public String getTenND() {
        return tenND;
    }

    public void setTenND(String tenND) {
        this.tenND = tenND;
    }

    public int getMaND() {
        return maND;
    }

    public void setMaND(int maND) {
        this.maND = maND;
    }

    public int getMaNT() {
        return maNT;
    }

    public void setMaNT(int maNT) {
        this.maNT = maNT;
    }

    public TrangThai getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThai trangThai) {
        this.trangThai = trangThai;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayDanhGia() {
        return ngayDanhGia;
    }

    public void setNgayDanhGia(String ngayDanhGia) {
        this.ngayDanhGia = ngayDanhGia;
    }
}
