/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab4_mob2034.Menu;

import com.mycompany.lab4_mob2034.Service.EmployeeService;
import com.mycompany.lab4_mob2034.Service.StudentService;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class menu {

    public static final StudentService stds = new StudentService();
    public static final EmployeeService es = new EmployeeService();
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Thêm nhân viên");
            System.out.println("4. Tìm nhân viên theo ID");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int i = Integer.parseInt(sc.nextLine());
            switch (i) {
                case 1 -> stds.themSinhVien();
                case 2 -> stds.hienThiDanhSach();
                case 3 -> es.ThemNhanVien();
                case 4 -> es.TimNVByMaID();
                case 0 -> running = false;
                default ->
                    System.out.println("Lỗi: vui lòng nhập lại!");
            }
        }

        System.out.println("Thoát chương trình.");
    }

}
