/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_mob1024.Service;

import com.mycompany.lab5_mob1024.Model.StudentModel;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<StudentModel> students = new ArrayList<>();

    public void addStudent(StudentModel s) {
        students.add(s);
    }

    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        for (StudentModel s : students) {
            System.out.println(s);
        }
    }

    // ===== Bài 1 =====
    public void writeNames(String file) {
        List<String> names = List.of("Nguyen Van A", "Tran Thi B", "Le Van C");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String name : names) {
                bw.write(name);
                bw.newLine();
            }
            System.out.println("Ghi file txt thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public void readNames(String file) {
        File f = new File(file);

        if (!f.exists()) {
            System.out.println("File không tồn tại!");
            return;
        }

        if (f.length() == 0) {
            System.out.println("File rỗng!");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("Danh sách tên:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    // ===== Bài 2,3 =====
    public void saveFile(String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(students);
            System.out.println("Lưu file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi lưu file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFile(String file) {
        File f = new File(file);

        if (!f.exists()) {
            System.out.println("File chưa tồn tại, tạo mới!");
            students = new ArrayList<>();
            return;
        }

        if (f.length() == 0) {
            System.out.println("File rỗng!");
            students = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            students = (List<StudentModel>) ois.readObject();
            System.out.println("Đọc file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi IO: " + e.getMessage());
            students = new ArrayList<>();
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi class: " + e.getMessage());
            students = new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Sai định dạng dữ liệu!");
            students = new ArrayList<>();
        }
    }

    // ===== Validate =====
    public StudentModel createStudent(String id, String name, String gpaStr) {
        if (id.isEmpty() || name.isEmpty()) {
            throw new IllegalArgumentException("Không được để trống!");
        }

        double gpa;
        try {
            gpa = Double.parseDouble(gpaStr);
        } catch (Exception e) {
            throw new IllegalArgumentException("GPA phải là số!");
        }

        if (gpa < 0 || gpa > 10) {
            throw new IllegalArgumentException("GPA phải từ 0-10!");
        }

        return new StudentModel(id, name, gpa);
    }
}