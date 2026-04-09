/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8_mob1024.Service;

import com.mycompany.lab8_mob1024.Model.Bai2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Bai2Service {
    public void run() {
        Scanner sc = new Scanner(System.in);
        List<Bai2> list = new ArrayList<>();

        System.out.print("Nhập số lượng sinh viên: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nSinh viên " + (i + 1) + ":");

            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Tên: ");
            String name = sc.nextLine();

            double gpa;

            while (true) {
                try {
                    System.out.print("GPA: ");
                    gpa = Double.parseDouble(sc.nextLine());

                    Bai2 s = new Bai2(id, name, gpa);
                    list.add(s);
                    break;

                } catch (Exception e) {
                    System.out.println("GPA không hợp lệ! Nhập lại (0 - 4.0)");
                }
            }
        }

        System.out.println("\nDanh sách sinh viên đủ học bổng:");
        for (Bai2 s : list) {
            if (s.isScholarshipEligible()) {
                s.display();
            }
        }
    }
}

