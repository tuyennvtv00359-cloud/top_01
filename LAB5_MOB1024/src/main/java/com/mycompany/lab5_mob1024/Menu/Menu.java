/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5_mob1024.Menu;

import com.mycompany.lab5_mob1024.Model.StudentModel;
import com.mycompany.lab5_mob1024.Service.StudentService;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Menu {
    public static void main(String[] args) {

        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);
        String fileDat = "students.dat";
        String fileTxt = "names.txt";
        service.loadFile(fileDat);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị");
            System.out.println("3. Lưu file");
            System.out.println("4. Đọc file");
            System.out.println("5. Ghi file txt");
            System.out.println("6. Đọc file txt");
            System.out.println("0. Thoát");

            System.out.print("Chọn: ");
            int n = Integer.parseInt(sc.nextLine());

            switch (n) {
                case 1:
                    try {
                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("GPA: ");
                        String gpa = sc.nextLine();

                        StudentModel s = service.createStudent(id, name, gpa);
                        service.addStudent(s);

                        System.out.println("Thêm thành công!");
                    } catch (Exception e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;

                case 2:
                    service.showStudents();
                    break;

                case 3:
                    service.saveFile(fileDat);
                    break;

                case 4:
                    service.loadFile(fileDat);
                    break;

                case 5:
                    service.writeNames(fileTxt);
                    break;

                case 6:
                    service.readNames(fileTxt);
                    break;

                case 0:
                    service.saveFile(fileDat);
                    System.out.println("Thoát!");
                    return;

                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }
}
