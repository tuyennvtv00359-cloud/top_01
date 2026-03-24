/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3_mob2034.Service;

import com.mycompany.lab3_mob2034.Model.Student;
import com.mycompany.lab3_mob2034.Model.StudentType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author LENOVO
 */
public class ServiceStudent {

    public static final Scanner sc = new Scanner(System.in);
    public static final List<Student> Hs = new ArrayList<>();
    public static final List<String> DsHS = new ArrayList<>();

    public static void AddHs() {
        System.out.print("Nhập số lượng thêm học sinh: ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("==============================================================");
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập ID học sinh: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập tên học sinh: ");
            String name = sc.nextLine();
            System.out.print("Nhập trạng thái của học sinh 'regular', ''part_time', 'international'\n Nhập trạng thái:  ");
            StudentType type = StudentType.valueOf(sc.nextLine().toUpperCase());
            System.out.print("Nhập điểm: ");
            float gpa = sc.nextFloat();
            sc.nextLine();
            Student hs = new Student(id, name, type, gpa);
            Hs.add(hs);
            System.out.println("==============================================================");
            System.out.println("Thêm thành công");
        }

    }

    public static void locDsHsINTERandGPA() {
        for (Student hs : Hs) {
            if (hs.getType() == StudentType.INTERNATIONAL && hs.getGpa() >= 3.2) {
                DsHS.add(hs.toString());
            }
        }
        System.out.println("Danh sách học sinh có trạng thái INTERNATIONAL và gpa >= 3.2 ");
        for (String hs : DsHS) {
            System.out.print(hs);
        }
    }

    public static void Top3Hs() {
        Collections.sort(Hs, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return Float.compare(b.getGpa(), a.getGpa());
            }
        });
        System.out.println("Danh sách top 3 học sinh xuất sắc: ");
        for (int i = 0; i < Math.min(3, Hs.size()); i++) {
            System.out.println(Hs.get(i));
        }
    }

    public static void HsPartTime() {
        System.out.println("Danh sách học sinh Part Time: ");
        for (Student hs : Hs) {
            if (hs.getType() == StudentType.PART_TIME) {
                System.out.println(hs.toString());
            }
        }
    }

    public static void DemHsTheoType() {
        Map<StudentType, Long> countByType = Hs.stream()
                .collect(Collectors.groupingBy(Student::getType, Collectors.counting()));

        System.out.println("Số sinh viên theo loại:");
        countByType.forEach((type, count) -> System.out.println(type + ": " + count));
    }

    public static void HsTBMax() {
        Map<StudentType, Double> avgGpaByType = Hs.stream()
                .collect(Collectors.groupingBy(Student::getType, Collectors.averagingDouble(Student::getGpa)));

        System.out.println("\nGPA trung bình theo loại:");
        avgGpaByType.forEach((type, avgGpa) -> System.out.println(type + ": " + avgGpa));
    }

    public void HsTBCaoNhat() {
        Map<StudentType, Double> avgGpaByType = Hs.stream()
                .collect(Collectors.groupingBy(Student::getType, Collectors.averagingDouble(Student::getGpa)));

        Optional<Map.Entry<StudentType, Double>> maxAvgGpaType = avgGpaByType.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        if (maxAvgGpaType.isPresent()) {
            System.out.println("Loại sinh viên GPA trung bình cao nhất: "
                    + maxAvgGpaType.get().getKey()
                    + " với GPA: " + maxAvgGpaType.get().getValue());
        }
    }
}

