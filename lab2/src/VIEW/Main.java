/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VIEW;

import MODEL.Employee;
import SERVICE.EmployeeService;
import SERVICE.ProductService;
import SERVICE.StudentService;
import enumm.StudentType;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService studentService = new StudentService();
        ProductService productService = new ProductService();
        EmployeeService employeeService = new EmployeeService();

        studentService.fakeData();
        productService.fakeData();

        int choice;

        do{

            System.out.println("\n===== MENU =====");
            System.out.println("1. Student");
            System.out.println("2. Product");
            System.out.println("3. Employee");
            System.out.println("0. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:

                    System.out.println("1. Hien thi tat ca");
                    System.out.println("2. Hien thi REGULAR");
                    System.out.println("3. Dem so luong");

                    int c1 = sc.nextInt();

                    if(c1==1)
                        studentService.showAll();

                    if(c1==2)
                        studentService.showByType(StudentType.REGULAR);

                    if(c1==3)
                        studentService.count();

                    break;

                case 2:

                    productService.showAll();
                    productService.statistic();

                    break;

                case 3:

                    System.out.println("1. Them");
                    System.out.println("2. Hien thi");
                    System.out.println("3. Tim");
                    System.out.println("4. Cap nhat luong");

                    int c2 = sc.nextInt();
                    sc.nextLine();

                    if(c2==1){

                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();

                        employeeService.add(new Employee(id,name,salary));

                    }

                    if(c2==2)
                        employeeService.showAll();

                    if(c2==3){

                        System.out.print("Nhap ID: ");
                        String id = sc.nextLine();

                        System.out.println(employeeService.find(id));

                    }

                    if(c2==4){

                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("Luong moi: ");
                        double s = sc.nextDouble();

                        employeeService.updateSalary(id,s);

                    }

                    break;

            }

        }while(choice!=0);

    }
}
