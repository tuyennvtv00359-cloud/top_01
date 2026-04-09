/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8_mob1024.Service;

import com.mycompany.lab8_mob1024.Model.StudentBai1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class StudentBai1Service {

    public void run() {
        Scanner sc = new Scanner(System.in);
        List<StudentBai1> list = new ArrayList<>();

        System.out.println("Nhập 5 điểm (nhập 'null' nếu chưa có điểm):");

        for (int i = 0; i < 5; i++) {
            System.out.print("Điểm " + (i + 1) + ": ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("null")) {
                list.add(new StudentBai1(null));
            } else {
                int value = Integer.parseInt(input);
                list.add(new StudentBai1(value));
            }
        }

        System.out.println("\nDanh sách điểm:");
        for (StudentBai1 s : list) {
            System.out.println(s.getValue());
        }

        int sum = 0, count = 0;
        for (StudentBai1 s : list) {
            if (s.getValue() != null) {
                sum += s.getValue();
                count++;
            }
        }

        double avg = count == 0 ? 0 : (double) sum / count;
        System.out.println("Điểm trung bình: " + avg);

        if (avg >= 8) {
            System.out.println("Xếp loại: Giỏi");
        } else if (avg >= 6.5) {
            System.out.println("Xếp loại: Khá");
        } else {
            System.out.println("Xếp loại: Trung bình");
        }
    }
}
