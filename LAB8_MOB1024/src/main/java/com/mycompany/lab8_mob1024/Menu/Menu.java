/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab8_mob1024.Menu;

import com.mycompany.lab8_mob1024.Service.Bai2Service;
import com.mycompany.lab8_mob1024.Service.Bai4Service;
import com.mycompany.lab8_mob1024.Service.EmployeeService;
import com.mycompany.lab8_mob1024.Service.StudentBai1Service;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Menu {

    public static final Scanner sc = new Scanner(System.in);
    public static final StudentBai1Service st1 = new StudentBai1Service();
    public static final Bai2Service b2 = new Bai2Service();
    public static final EmployeeService b3 = new EmployeeService();
    public static final Bai4Service b4 = new Bai4Service();
    
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=======MENU=======");
            System.out.println("1. Bài 1 ");
            System.out.println("2. Bài 2 ");
            System.out.println("3. Bài 3 ");
            System.out.println("4. Bài 4 ");
            System.out.println("0. Thoát trương trình. ");

            System.out.print("Mời nhập lựa chọn: ");
            int n = Integer.parseInt(sc.nextLine());
            switch (n) {
                case 1:
                    st1.run();
                    break;
                case 2:
                    b2.run();
                    break;
                case 3:
                    b3.run();
                    break;
                case 4:
                    b4.run();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Nhập không hợp lệ vui lòng nhập lại. ");

            }
        }

    }

}
