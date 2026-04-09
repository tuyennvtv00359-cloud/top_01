/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab6_mob1024.Menu;

import com.mycompany.lab6_mob1024.Model.Student;
import com.mycompany.lab6_mob1024.Model.Tree;
import com.mycompany.lab6_mob1024.Service.StudentService;
import com.mycompany.lab6_mob1024.Service.TreeService;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */

public class Menu {
    private static final Scanner sc = new Scanner(System.in);
    private static final StudentService studentService = new StudentService();
    private static final TreeService treeService = new TreeService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== MENU CHÍNH =====");
            System.out.println("1. Quản lý Student");
            System.out.println("2. Quản lý Tree");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> studentMenu();
                case 2 -> treeMenu();
                case 0 -> {
                    System.out.println("Đã thoát.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void studentMenu() {
        while (true) {
            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Hiển thị tất cả");
            System.out.println("2. Thêm student");
            System.out.println("3. Sửa student");
            System.out.println("4. Xóa student");
            System.out.println("5. Tìm student theo ID");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> printStudents(studentService.findAll());
                case 2 -> {
                    Student s = inputStudent();
                    boolean ok = studentService.insert(s);
                    System.out.println(ok ? "Thêm thành công!" : "Thêm thất bại!");
                    printStudents(studentService.findAll());
                }
                case 3 -> {
                    Student s = inputStudent();
                    boolean ok = studentService.update(s);
                    System.out.println(ok ? "Cập nhật thành công!" : "Cập nhật thất bại!");
                    printStudents(studentService.findAll());
                }
                case 4 -> {
                    System.out.print("Nhập student_id cần xóa: ");
                    int id = readInt();
                    boolean ok = studentService.delete(id);
                    System.out.println(ok ? "Xóa thành công!" : "Xóa thất bại!");
                    printStudents(studentService.findAll());
                }
                case 5 -> {
                    System.out.print("Nhập student_id cần tìm: ");
                    int id = readInt();
                    Student s = studentService.findById(id);
                    System.out.println(s != null ? s : "Không tìm thấy student.");
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void treeMenu() {
        while (true) {
            System.out.println("\n===== TREE MENU =====");
            System.out.println("1. Hiển thị tất cả");
            System.out.println("2. Thêm node");
            System.out.println("3. Sửa node");
            System.out.println("4. Xóa node");
            System.out.println("5. Tìm node theo ID");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> printTrees(treeService.findAll());
                case 2 -> {
                    Tree t = inputTree();
                    boolean ok = treeService.insert(t);
                    System.out.println(ok ? "Thêm thành công!" : "Thêm thất bại!");
                    printTrees(treeService.findAll());
                }
                case 3 -> {
                    Tree t = inputTree();
                    boolean ok = treeService.update(t);
                    System.out.println(ok ? "Cập nhật thành công!" : "Cập nhật thất bại!");
                    printTrees(treeService.findAll());
                }
                case 4 -> {
                    System.out.print("Nhập node_id cần xóa: ");
                    int id = readInt();
                    boolean ok = treeService.delete(id);
                    System.out.println(ok ? "Xóa thành công!" : "Xóa thất bại!");
                    printTrees(treeService.findAll());
                }
                case 5 -> {
                    System.out.print("Nhập node_id cần tìm: ");
                    int id = readInt();
                    Tree t = treeService.findById(id);
                    System.out.println(t != null ? t : "Không tìm thấy node.");
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static Student inputStudent() {
        System.out.print("Nhập student_id: ");
        int id = readInt();

        System.out.print("Nhập student_name: ");
        String name = sc.nextLine();

        System.out.print("Nhập gender: ");
        String gender = sc.nextLine();

        System.out.print("Nhập gpa (để trống nếu null): ");
        String gpaText = sc.nextLine();
        Float gpa = gpaText.isBlank() ? null : Float.parseFloat(gpaText);

        return new Student(id, name, gender, gpa);
    }

    private static Tree inputTree() {
        System.out.print("Nhập node_id: ");
        int id = readInt();

        System.out.print("Nhập node_name: ");
        String name = sc.nextLine();

        System.out.print("Nhập parent_id (để trống nếu null): ");
        String parentText = sc.nextLine();
        Integer parentId = parentText.isBlank() ? null : Integer.parseInt(parentText);

        System.out.print("Nhập level: ");
        int level = readInt();

        return new Tree(id, name, parentId, level);
    }

    private static int readInt() {
        while (true) {
            try {
                String line = sc.nextLine();
                return Integer.parseInt(line.trim());
            } catch (Exception e) {
                System.out.print("Nhập số hợp lệ: ");
            }
        }
    }

    private static void printStudents(List<Student> list) {
        System.out.println("\n--- DANH SÁCH STUDENT ---");
        if (list.isEmpty()) {
            System.out.println("Không có dữ liệu.");
            return;
        }
        list.forEach(System.out::println);
    }

    private static void printTrees(List<Tree> list) {
        System.out.println("\n--- DANH SÁCH TREE ---");
        if (list.isEmpty()) {
            System.out.println("Không có dữ liệu.");
            return;
        }
        list.forEach(System.out::println);
    }
}