/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8_mob1024.Service;

import com.mycompany.lab8_mob1024.Model.Bai4_Model;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Bai4Service {

    public void run() {
        Scanner sc = new Scanner(System.in);

        String welcome = """
                =========================
                CHÀO MỪNG BẠN ĐẾN VỚI APP
                =========================
                """;
        System.out.println(welcome);

        System.out.print("Nhập tên người nhận: ");
        String emailName = sc.nextLine();

        String email = """
                Xin chào %s,

                Bạn đã đăng ký thành công.

                Trân trọng,
                Admin
                """.formatted(emailName);

        System.out.println("\n--- EMAIL ---");
        System.out.println(email);

        System.out.print("Nhập tên sinh viên: ");
        String name = sc.nextLine();

        System.out.print("Nhập GPA: ");
        double gpa = Double.parseDouble(sc.nextLine());

        Bai4_Model sv = new Bai4_Model(name, gpa);

        String html = """
                <html>
                    <body>
                        <h1>Thông tin sinh viên</h1>
                        <p>Tên: %s</p>
                        <p>GPA: %.2f</p>
                    </body>
                </html>
                """.formatted(sv.getName(), sv.getGpa());

        System.out.println("\n--- HTML ---");
        System.out.println(html);

        String sql = """
                SELECT *
                FROM Student
                WHERE GPA > 3.0
                """;

        System.out.println("\n--- SQL ---");
        System.out.println(sql);
    }
}
