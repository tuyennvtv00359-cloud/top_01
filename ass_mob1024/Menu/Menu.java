/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ass_mob1024.Menu;

import com.mycompany.ass_mob1024.Service.AdminService;
import com.mycompany.ass_mob1024.Service.Service;
import com.mycompany.ass_mob1024.Service.UserService;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class Menu {

    private static final Scanner sc = new Scanner(System.in);
    private static final Service sv = new Service();
    private static final AdminService asv = new AdminService();
    private static final UserService usv = new UserService();
    private static final Pattern PHONE_PATTERN = Pattern.compile("^0\\d{9}$");

    public static void main(String[] args) {
        boolean running = true;
        int userid, role = 1;
        while (running) {
            System.out.println("\n===================================  HAPPY NEW YEAR  ====================================");
            while (true) {
                System.out.print("   | Nhập sđt để đăng nhập: ");
                String sdt = sc.nextLine().trim();
                if (sdt.equalsIgnoreCase("admin")) {
                    role = 2;
                    userid = 0;
                    break;
                }
                if (!PHONE_PATTERN.matcher(sdt).matches()) {
                    System.out.println("Số điện thoại không hợp lệ! Nhập lại.");
                    continue;
                }
                userid = sv.getUserID(sdt);
                if (userid < 0) {
                    System.out.println("Không tìm thấy user sử dụng sdt này.");
                    continue;
                }
                System.out.println("Đăng nhập thành công");
                System.out.println("Kết nối database thành công");
                break;
            }             
            try {
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
                            System.out.println("7. Đăng thông tin nhà trọ mới");
                            System.out.println("8. Xem thông tin các nhà trọ đã đăng");
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
                                case 7 -> {
                                    usv.addNhaTro(userid);
                                }
                                case 8 -> { 
                                    usv.findByID(userid);
                                }
                                case 9 -> {
                                    urunning = false;
                                }
                                case 0 -> {
                                    try (sc) {
                                        System.out.println("Đã thoát!");
                                        urunning = false;
                                        running = false;
                                    }
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
                            System.out.println("6. Khôi phục nhà trọ đã xóa");
                            System.out.println("7. Backup toàn bộ dữ liệu");
                            System.out.println("8. Restore toàn bộ dữ liệu");
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
                                    asv.khoiPhuc();
                                }
                                case 7 -> {
                                    asv.backup();
                                }
                                case 8 -> {
                                    asv.restore();
                                }
                                case 9 -> {
                                    role = 1;
                                    arunning = false;
                                }
                                case 0 -> {
                                    try (sc) {
                                        System.out.println("Đã thoát!");
                                        running = false;
                                        arunning = false;
                                    }
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
