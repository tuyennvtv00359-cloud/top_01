/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ass_mob1024.Service;

/**
 *
 * @author PC
 */
import com.mycompany.ass_mob1024.DataAccessObject.DanhGiaDAO;
import com.mycompany.ass_mob1024.DataAccessObject.NguoiDungDAO;
import com.mycompany.ass_mob1024.DataAccessObject.NhaTroDAO;
import com.mycompany.ass_mob1024.Model.DanhGia;
import com.mycompany.ass_mob1024.Model.TrangThai;
import java.util.Scanner;

public class Service {

    protected final Scanner sc = new Scanner(System.in);
    protected final NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
    protected final NhaTroDAO nhaTroDAO = new NhaTroDAO();
    protected final DanhGiaDAO danhGiaDAO = new DanhGiaDAO();

    public void addDanhGia() {
        System.out.println("============ THÊM ĐÁNH GIÁ MỚI ===========");

        try {
            System.out.print("Mã người đánh giá: ");
            int maND = Integer.parseInt(sc.nextLine());
            System.out.print("Mã nhà trọ: ");
            int maNT = Integer.parseInt(sc.nextLine());
            System.out.print("LIKE/DISLIKE: ");
            TrangThai status = TrangThai.valueOf(sc.nextLine().toUpperCase());
            System.out.print("Nội dung đánh giá: ");
            String content = sc.nextLine();

            DanhGia dg = new DanhGia(maND, maNT, status, content);
            boolean result = danhGiaDAO.addDanhGia(dg);
            System.out.println(result ? "Đã thêm thành công!" : "Lỗi trong quá trình thêm!");

        } catch (Exception e) {
            System.out.println("Input lỗi");
        }
    }

    
    public void addDanhGia(int maND) {
        System.out.println("============ THÊM ĐÁNH GIÁ MỚI ===========");

        try {
            System.out.print("Mã nhà trọ bạn muốn đánh giá: ");
            int maNT = Integer.parseInt(sc.nextLine());
            System.out.print("LIKE/DISLIKE: ");
            TrangThai status = TrangThai.valueOf(sc.nextLine().toUpperCase());
            System.out.print("Nội dung đánh giá: ");
            String content = sc.nextLine();

            DanhGia dg = new DanhGia(maND, maNT, status, content);
            boolean result = danhGiaDAO.addDanhGia(dg);
            System.out.println(result ? "Đã thêm thành công!" : "Lỗi trong quá trình thêm!");

        } catch (Exception e) {
            System.out.println("Input lỗi");
        }
    }

}
