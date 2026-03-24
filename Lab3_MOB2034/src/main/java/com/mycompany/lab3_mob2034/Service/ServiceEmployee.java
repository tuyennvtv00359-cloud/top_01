/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3_mob2034.Service;

import com.mycompany.lab3_mob2034.Model.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class ServiceEmployee {

    public static final Scanner sc = new Scanner(System.in);
    public static final List<Employee> DsNV = new ArrayList<>();
    public static final List<String> TenNV = new ArrayList<>();

    public static void AddNV() {
        System.out.print("Nhập số lượng: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("\nVui lòng nhập thông tin: ");
            System.out.print("\nNhập ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("\nTên nhân viên: ");
            String tennv = sc.nextLine();
            System.out.print("\nNhập lương nhân viên: ");
            int salary = Integer.parseInt(sc.nextLine());
            Employee em = new Employee(id, tennv, salary);
            DsNV.add(em);
        }
        System.out.println("\nDanh sách nhân viên đã nhập: ");
        for (Employee em : DsNV) {
            System.out.println(em);
        }
    }

    public static void LocSalary() {
        System.out.println("Tên nhân viên có mức lương hơn 15000000");
        boolean loc = false;
        for (Employee em : DsNV) {
            if (em.getSalary() > 15000000) {
                System.out.print(em);
                loc = true;
            }
        }
        if (loc == false) {
            System.out.println("Không có nhân viên dưới mức lương 15000000");
        }
    }

    public static void DsTenNV() {
        for (Employee em : DsNV) {
            TenNV.add(em.getName());
        }
        System.out.println("Danh sách tên nhân viên: ");
        for (String ten : TenNV) {
            System.out.println(ten);
        }
    }

    public static void DemSoNV() {
        int count = 0;
        char tam;
        for (Employee em : DsNV) {
            tam = em.getName().charAt(0);
            if (tam == 'A' || tam == 'a') {
                count++;
            }
        }
        System.out.println("Số nhân viên bắt đầu bằng chữ 'A': " + count);
    }

    public static void TongLuongNV() {

        int tong = 0;
        for (Employee em : DsNV) {
            tong = tong + em.getSalary();

        }
        System.out.println("Tổng lương nhân viên: " + tong);
    }

    public static void LuongTB() {
        float tb = 0;
        int tong = 0;
        int count = 0;
        for (Employee em : DsNV) {
            tong = tong + em.getSalary();
            count++;
        }
        tb = (float) tong / count;
        System.out.println("Lương trung bình: " + tb);
    }

    public static void MaxLuong() {
        int max = 0;
        for (Employee em : DsNV) {
        if(max < em.getSalary())
            max = em.getSalary();
        }
        System.out.println("Lương cao nhất: " + max);
    }

}
