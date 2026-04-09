/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8_mob1024.Service;

import com.mycompany.lab8_mob1024.Annotation.Developer;
import com.mycompany.lab8_mob1024.Model.Employee;
import com.mycompany.lab8_mob1024.Model.Manager;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */

@Developer(name = "Nam", version = "1.0")
public class EmployeeService {

    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập lương Employee: ");
        double empSalary = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập lương Manager: ");
        double mgrSalary = Double.parseDouble(sc.nextLine());

        Employee emp = new Employee(empSalary);
        Manager mgr = new Manager(mgrSalary);

        System.out.println("\n--- KẾT QUẢ ---");
        System.out.println("Employee (cũ - deprecated): " + emp.getSalary());
        System.out.println("Employee (mới): " + emp.getSalaryNew());

        System.out.println("Manager (override cũ): " + mgr.getSalary());
        System.out.println("Manager (mới): " + mgr.getSalaryNew());

        Class<?> clazz = this.getClass();

        if (clazz.isAnnotationPresent(Developer.class)) {
            Developer dev = clazz.getAnnotation(Developer.class);

            System.out.println("\n--- THÔNG TIN DEVELOPER ---");
            System.out.println("Name: " + dev.name());
            System.out.println("Version: " + dev.version());
        }
    }
}
