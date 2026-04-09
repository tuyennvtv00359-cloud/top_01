/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ass_mob1024.Service;

import com.mycompany.ass_mob1024.Model.DanhGia;
import com.mycompany.ass_mob1024.Model.NhaTro;
import java.util.List;

/**
 *
 * @author PC
 */
public class UserService extends Service {

    public void viewAll() {
        List<NhaTro> list = nhaTroDAO.viewAll();
        System.out.println("\n=================================================== DANH SÁCH =====================================================");
        System.out.printf("%-20s| %-17s| %-15s| %-10s| %-15s| %-15s| %10s\n",
                "Người đăng", "Loại nhà", "Giá tiền", "Diện tích", "Quận", "Ngày đăng", "Score");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        for (NhaTro nt : list) {
            System.out.printf("%-20s| %-17s| %-15s| %-10s| %-15s| %-15s| %10.1f\n",
                    nt.getTenND(),
                    nt.getTenLoai(),
                    nt.getGiaTien(),
                    nt.getDienTich(),
                    nt.getQuan(),
                    nt.getNgayDang(),
                    nt.getScore()
            );
        }
        System.out.println("====================================================================================================================\n");
    }

    public void findList() {

        try {

            System.out.println("===== TÌM KIẾM NHÀ TRỌ =====");
            System.out.print("Quận: ");
            String quan = sc.nextLine();
            if (quan.isEmpty()) {
                quan = null;
            }
            System.out.print("Mã loại nhà: ");
            String loaiInput = sc.nextLine();
            Integer maLoai = loaiInput.isEmpty() ? null : Integer.valueOf(loaiInput);
            System.out.print("Diện tích nhỏ nhất: ");
            String dtMinInput = sc.nextLine();
            Double dtMin = dtMinInput.isEmpty() ? null : Double.valueOf(dtMinInput);
            System.out.print("Diện tích lớn nhất: ");
            String dtMaxInput = sc.nextLine();
            Double dtMax = dtMaxInput.isEmpty() ? null : Double.valueOf(dtMaxInput);
            System.out.print("Giá nhỏ nhất: ");
            String giaMinInput = sc.nextLine();
            Double giaMin = giaMinInput.isEmpty() ? null : Double.valueOf(giaMinInput);
            System.out.print("Giá lớn nhất: ");
            String giaMaxInput = sc.nextLine();
            Double giaMax = giaMaxInput.isEmpty() ? null : Double.valueOf(giaMaxInput);
            System.out.print("Giới hạn thời gian kể từ ngày đăng: ");
            String dateInput = sc.nextLine();
            Integer ngayDang = dateInput.isEmpty() ? null : Integer.valueOf(dateInput);

            List<NhaTro> list
                    = nhaTroDAO.findList(quan, maLoai, dtMin, dtMax, giaMin, giaMax, ngayDang);
            if (list.isEmpty()) {
                System.out.println("Không tìm thấy nhà trọ phù hợp yêu cầu.");
                return;
            }

            System.out.println("\n========================================= KẾT QUẢ ========================================");
            System.out.printf("%-5s| %-10s| %-12s| %-15s| %10s\n",
                    "Mã", "Giá", "Diện tích", "Quận", "Score");
            System.out.println("--------------------------------------------------------------------------------------------");
            for (NhaTro nt : list) {
                System.out.printf(
                        "%-5s| %-10s| %-12s| %-15s| %10s\n",
                        nt.getMaNT(),
                        nt.getGiaTien(),
                        nt.getDienTich(),
                        nt.getQuan(),
                        nt.getScore()
                );
            }
            System.out.println("==============================================================================================\n");
        } catch (Exception e) {
            System.out.println("Lỗi input" + e.getMessage());
        }
    }

    public void findByMa() {
        try {
            System.out.print("Nhập mã nhà trọ cần tìm: ");
            int maNT = Integer.parseInt(sc.nextLine());
            System.out.println("\n=======================  THÔNG TIN CHI TIẾT  =======================");
            nhaTroDAO.findByMa(maNT);
            System.out.println("=====================================================================\n");
        } catch (Exception e) {
            System.out.println("Input lỗi");
        }
    }
    
    public void findByID(int maND) {
        try {   
            List<NhaTro> list = nhaTroDAO.findByID(maND);
            
            System.out.println("\n==================================================== DANH SÁCH NHÀ TRỌ CỦA BẠN ======================================================");
            System.out.printf("%-7s| %-15s| %-12s| %-10s| %-13s| %-15s| %-12s| %-7s| %-15s\n",
                "Mã nhà", "Loại nhà", "Giá tiền", "Diện tích", "Quận", "Địa chỉ", "Ngày đăng", "Score", "Trạng thái");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");

            for (NhaTro nt : list) {
                System.out.printf("%-7s| %-15s| %-12s| %-10s| %-13s| %-15s| %-12s| %-7s| %-15s\n",
                    nt.getMaNT(),
                    nt.getTenLoai(),
                    nt.getGiaTien(),
                    nt.getDienTich(),
                    nt.getQuan(),
                    nt.getDiaChi(),
                    nt.getNgayDang(),
                    nt.getScore(),
                    nt.getTrangThai()
                );
            }
            System.out.println("\n=====================================================================================================================================");
            boolean running = true;
            while (running) {
                System.out.println("\n------ Danh sách các thao tác ------");   
                System.out.println("  | 1. Sửa thông tin nhà trọ đã đăng");    
                System.out.println("  | 2. Xóa thông tin nhà trọ đã đăng");
                System.out.println("  | 0. Thoát");
                System.out.print("       -> Lựa chọn: ");
                int choice = Integer.parseInt(sc.nextLine().trim());
                switch (choice) {
                    case 1 -> {
                        System.out.println("Chức năng này chưa tồn tại");
                    }
                    case 2 -> {
                        System.out.print("Nhập vào mã nhà trọ cần xóa: ");
                        int maNT = Integer.parseInt(sc.nextLine().trim());
                        boolean found = false;
                        for (NhaTro nt : list) {
                            if (nt.getMaNT() == maNT) {
                                nhaTroDAO.deleteByMa(maNT);
                                found = true;
                                break;
                            }
                        }
                        if (!found) 
                            System.out.println("Mã trên không tồn tại trong danh sách nhà trọ của bạn");
                    }
                    case 0 -> {
                        running = false;
                    }
                    default -> {
                        System.out.println("Chức năng không hợp lệ!");
                    }       
                }
            }  
        } catch (Exception e) {
            System.out.println("Lỗi input!");
        }
    }

    public void viewRating() {
        try {

            System.out.print("Nhập mã nhà trọ: ");
            int maNT = Integer.parseInt(sc.nextLine().trim());

            List<DanhGia> list = danhGiaDAO.viewRating(maNT);

            System.out.println("\n===================== DANH SÁCH ĐÁNH GIÁ =====================");
            System.out.printf("%-23s %-15s %20s\n",
                    "Tên người đánh giá", "Like/Dislike", "Đánh giá chi tiết");
            System.out.println("--------------------------------------------------------------");

            for (DanhGia dg : list) {
                System.out.printf("%-23s %-15s %20s\n",
                        dg.getTenND(),dg.getTrangThai(),dg.getNoiDung());
            }
            System.out.println("==============================================================\n");

        } catch (Exception e) {
            System.out.println("Input lỗi");
        }
    }

    public void viewTopScore() {

        List<NhaTro> list = nhaTroDAO.viewTopScore();

        System.out.println("\n=================== TOP 10 NHÀ TRỌ ==================");
        System.out.printf("%-8s %-15s %-12s %10s\n",
                "Mã", "Quận", "Giá tiền", "Score");
        System.out.println("------------------------------------------------------");

        for (NhaTro nt : list) {
            System.out.printf("%-8d %-15s %-12.0f %10.1f\n",
                    nt.getMaNT(),
                    nt.getQuan(),
                    nt.getGiaTien(),
                    nt.getScore()
            );
        }
        System.out.println("======================================================\n");
    }

}
