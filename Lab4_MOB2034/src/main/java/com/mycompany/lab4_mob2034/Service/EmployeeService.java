/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4_mob2034.Service;

import com.mycompany.lab4_mob2034.Model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class EmployeeService {

    public static final Scanner sc = new Scanner(System.in);
    public static final GenericManager<Employee> DsNV = new GenericManager<>();

    public static void ThemNhanVien() {
        System.out.println("Nhập số lượng nhân viên: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin nhân viên số " + (i + 1));
            int id;
            String name;
            double salary;
            while (true) {
                try {
                    System.out.println("Nhập id: ");
                    id = Integer.parseInt(sc.nextLine());
                    for (Employee nv : DsNV.getList()) {
                        if (nv.getId() == id) {
                            throw new Exception();
                        }
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Lỗi trùng id");
                }

            }

            System.out.println("Nhập tên: ");
            name = sc.nextLine();

            while (true) {
                try {
                    System.out.println("Nhập lương: ");
                    salary = sc.nextDouble();
                    if (salary < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Lỗi lương bị âm.");
                }
            }
            Employee nv = new Employee(id, name, salary);
            DsNV.them(nv);

        }
    }

    public void TimNVByMaID() {
        System.out.print("Nhập id nhân viên cần tìm: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean tim = false;
        for (Employee e : DsNV.getList()) {
            if (e.getId() == id) {
                e.inThongTin();
                tim = true;
            }
        }
        if (tim == false) {
            System.out.println("Không tìm thấy nhân viên có id đó.");
        }
    }


}
