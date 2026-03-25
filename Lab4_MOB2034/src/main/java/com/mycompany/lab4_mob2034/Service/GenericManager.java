/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4_mob2034.Service;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class GenericManager<T> {

    private ArrayList<T> list = new ArrayList<>();

    public void them(T item) {
        list.add(item);
    }

    public void inDanhSach() {
        try {
            if (list.isEmpty()) {

            }
        } catch (Exception e) {
            System.out.println("Danh sách đang rỗng.");
        }

        for (T item : list) {
            System.out.println(item);
        }
    }

    public int soLuong() {
        return list.size();
    }

    public ArrayList<T> getList() {
        return list;
    }
}
