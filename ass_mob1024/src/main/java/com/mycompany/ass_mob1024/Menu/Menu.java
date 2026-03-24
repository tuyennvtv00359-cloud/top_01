/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ass_mob1024.Menu;

import com.mycompany.ass_mob1024.Service.AdminService;
import com.mycompany.ass_mob1024.Service.UserService;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Menu {

    private static final Scanner sc = new Scanner(System.in);
    private static final AdminService asv = new AdminService();
    private static final UserService usv = new UserService();

    public static void main(String[] args) {
        int userid = 1;
        boolean running = true;
        while (running) {
            System.out.println("===================================  HAPPY NEW YEAR  ====================================");
            System.out.print("     | Login as (1=user,2=admin): ");
            try {
                int role = Integer.parseInt(sc.nextLine().trim());
                switch (role) {
                    case 1:
                        boolean urunning = true;
                        while (urunning) {
                            System.out.println("\n===============================  DANH SÁCH LỰA CHỌN CỦA USER  ===============================");
                            System.out.println("1. Xem danh sách nhà trọ được cho thuê");
                            System.out.println("2. Tìm nhà trọ theo yêu cầu");
                            System.out.println("3. Xem thông tin nhà trọ theo mã");
                            System.out.println("4. Xem đánh giá nhà trọ theo mã");
                            System.out.println("5. Danh sách 10 nhà trọ tốt nhất");
                            System.out.println("6. Thêm đánh giá của bạn");
                            System.out.println("9. Đăng xuất khỏi user");
                            System.out.println("0. Thoát");
                            System.out.print("  -> Lựa chọn của bạn: ");
                            int user = Integer.parseInt(sc.nextLine().trim());
                            switch (user) {
                                case 1 -> {
                                    usv.viewAll();
                                }
                                case 2 -> {
                                    usv.findList();
                                }
                                case 3 -> {
                                    usv.findByMa();
                                }
                                case 4 -> {
                                    usv.viewRating();
                                }
                                case 5 -> {
                                    usv.viewTopScore();
                                }
                                case 6 -> {
                                    usv.addDanhGia(userid);
                                }
                                case 9 -> {
                                    urunning = false;
                                }
                                case 0 -> {
                                    System.out.println("Đã thoát!");
                                    urunning = false;
                                    running = false;
                                    sc.close();
                                }
                                default ->
                                    System.out.println("Lựa chọn không hợp lệ!");
                            }
                        }
                        break;
                    case 2:
                        boolean arunning = true;
                        while (arunning) {
                            System.out.println("\n===============================  DANH SÁCH LỰA CHỌN CỦA ADMIN  ===============================");
                            System.out.println("1. Thêm thông tin người dùng mới");
                            System.out.println("2. Thêm thông tin nhà trọ mới");
                            System.out.println("3. Thêm thông tin đánh giá mới");
                            System.out.println("4. Xóa nhà trọ có đánh giá thấp");
                            System.out.println("5. Xóa nhà trọ quá hạn");
                            System.out.println("6. Sao lưu toàn bộ dữ liệu");
                            System.out.println("7. Phục hồi toàn bộ dữ liệu");
                            System.out.println("9. Đăng xuất khỏi admin");
                            System.out.println("0. Thoát");
                            System.out.print("  -> Lựa chọn của bạn: ");
                            int admin = Integer.parseInt(sc.nextLine().trim());
                            switch (admin) {
                                case 1 -> {
                                    asv.addUser();
                                }
                                case 2 -> {
                                    asv.addNhaTro();
                                }
                                case 3 -> {
                                    asv.addDanhGia();
                                }
                                case 4 -> {
                                    asv.deleteByScore();
                                }
                                case 5 -> {
                                    asv.deleteByTime();
                                }
                                case 6 -> {
                                    asv.backup();
                                }
                                case 7 -> {
                                    asv.restore();
                                }
                                case 9 -> {
                                    arunning = false;
                                }
                                case 0 -> {
                                    System.out.println("Đã thoát!");
                                    running = false;
                                    arunning = false;
                                    sc.close();
                                }
                                default ->
                                    System.out.println("Lựa chọn không hợp lệ!");
                            }
                        }
                        break;
                    case 0:
                        System.out.println("Đã thoát!");
                        running = false;
                        sc.close();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ!");
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
