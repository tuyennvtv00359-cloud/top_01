/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab3_mob2034.Menu;

import com.mycompany.lab3_mob2034.Service.ServiceEmployee;
import com.mycompany.lab3_mob2034.Service.ServiceStudent;
import com.mycompany.lab3_mob2034.Service.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Menu {

    private static final Scanner sc = new Scanner(System.in);
    private static final service srv = new service();
    private static final ServiceEmployee srve = new ServiceEmployee();
    private static final ServiceStudent srvsd = new ServiceStudent();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("==================== Menu ====================");
            System.out.println("1.  Thêm tên. ");
            System.out.println("2.  Lọc và in các tên có độ dài > 5.");
            System.out.println("3.  Sắp xếp tên theo thứ tự từ A - Z.");
            System.out.println("4.  Sắp xếp tên theo thứ tự tăng dần. ");
            System.out.println("5.  Thêm nhân viên.");
            System.out.println("6.  Lọc nhân viên có mức lương >= 15,000,000.");
            System.out.println("7.  Hiển thị tên nhân viên.");
            System.out.println("8.  Hiểu thị nhân viên có tên bắt đầu bằng chữ 'A'.");
            System.out.println("9.  Hiển thị tổng lương của nhân viên.");
            System.out.println("10. Hiển thị lương trung bình của nhân viên.");
            System.out.println("11. Hiểu thị lương cao nhất của nhân viên.");
            System.out.println("12. Thêm học sinh.");
            System.out.println("13. Lọc học sinh có trạng thái INTERNATIONAL và gpa >= 3.2.");
            System.out.println("14. Hiển thị top 3 học sinh xuất sắc nhất.");
            System.out.println("15. Hiển thị học sinh Part Time.");
            System.out.println("0.  Thoát.");
            System.out.print("Mời chọn chức năng: ");
            int s = Integer.parseInt(sc.nextLine());
            switch (s) {
                case 1 -> srv.AddNguoiDung();
                case 2 -> srv.LocTen();
                case 3 -> srv.SapXepAZ();
                case 4 -> srv.SapXepTheoDoDai();
                case 5 -> srve.AddNV();
                case 6 -> srve.LocSalary();
                case 7 -> srve.DsTenNV();
                case 8 -> srve.DemSoNV();
                case 9 -> srve.TongLuongNV();
                case 10 -> srve.LuongTB();
                case 11 -> srve.MaxLuong();
                case 12 -> srvsd.AddHs();
                case 13 -> srvsd.locDsHsINTERandGPA();
                case 14 -> srvsd.Top3Hs();
                case 15 -> srvsd.HsPartTime();
                case 16 -> srvsd.DemHsTheoType();
                case 17 -> srvsd.HsTBMax();
                case 18 -> srvsd.HsTBCaoNhat();
                case 0 -> running = false;
                default -> System.out.println("Vui lòng chọn lại chức || Chức năng không tồn tại...");
            }// end switch
        }// end while
    }
}
