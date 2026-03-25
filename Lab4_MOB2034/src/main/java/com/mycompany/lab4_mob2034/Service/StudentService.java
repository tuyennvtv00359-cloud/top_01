/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4_mob2034.Service;

import com.mycompany.lab4_mob2034.Model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class StudentService {

    public static final GenericManager<Student> DsHs = new GenericManager<>();
    public static final Scanner sc = new Scanner(System.in);

    public void themSinhVien() {
        System.out.println("Thêm sinh viên: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập thông tin sinh viên số: " + (i + 1));
            int id;
            String name;
            float gpa;
            while (true) {
                try {
                    System.out.print("Nhập id: ");
                    id = Integer.parseInt(sc.nextLine());
                    break;
                } catch (IllegalArgumentException e) {

                    System.out.println("Lỗi!");
                }
            }

            while (true) {
                try {
                    System.out.print("Nhập name: ");
                    name = sc.nextLine();
                    break;
                } catch (IllegalArgumentException e) {

                    System.out.println("Lỗi!");
                }
            }

            while (true) {
                try {

                    System.out.print("Nhập điểm: ");
                    gpa = Integer.parseInt(sc.nextLine());
                    if (gpa <= 0 || gpa >= 4) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {

                    System.out.println("Lỗi!");
                }
            }
            Student hs = new Student(id, name, gpa);
            DsHs.them(hs);
        }
    }

    public void hienThiDanhSach() {
        if (DsHs == null) {
            System.out.println("Danh sách sinh viên đang rỗng.");
            return;
        }

        System.out.println("===== DANH SÁCH SINH VIÊN =====");
        for (Student hs : DsHs.getList()) {
            hs.inThongTin();
        }
    }
}
