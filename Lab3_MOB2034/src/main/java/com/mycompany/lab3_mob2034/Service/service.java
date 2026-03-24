/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3_mob2034.Service;

import com.mycompany.lab3_mob2034.Model.Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class service {

    public static final Scanner sc = new Scanner(System.in);
    public static final List<Model> DsTen = new ArrayList<>();

    public static void AddNguoiDung() {
        System.out.print("Nhập số lượng: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập tên thứ " + (i + 1) + ": ");
            String name = sc.nextLine();
            DsTen.add(new Model(name));
        }
    }

    public static void LocTen() {
        boolean found = false;

        for (Model name : DsTen) {
            if (name.getName().trim().length() > 5) {
                System.out.println("Tên có độ dài tên 5 kí tự: " + name.getName());
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Không có tên dưới 5 kí tự");
        }
    }

    public static void SapXepAZ() {
        Collections.sort(DsTen, new Comparator<Model>() {
            @Override
            public int compare(Model o1, Model o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }

        }
        );
        System.out.println("Danh sách đã lọc theo thứ tự từ A - Z: ");
        for (Model name : DsTen) {
            System.out.println(name);
        }

    }

    public static void SapXepTheoDoDai() {
        Collections.sort(DsTen, new Comparator<Model>() {
            @Override
            public int compare(Model o1, Model o2) {
                return o1.getName().length() - o2.getName().length();
            }

        }
        );
        System.out.println("Danh sách đã lọc theo độ dài: ");
        for (Model name : DsTen) {
            System.out.println(name);
        }
    }
}
