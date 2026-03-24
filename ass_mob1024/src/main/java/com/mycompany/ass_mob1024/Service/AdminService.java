/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ass_mob1024.Service;

import com.mycompany.ass_mob1024.Model.DanhGia;
import com.mycompany.ass_mob1024.Model.NguoiDung;
import com.mycompany.ass_mob1024.Model.NhaTro;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author PC
 */
public class AdminService extends Service {

    private static final Pattern PHONE_PATTERN = Pattern.compile("^0\\d{9}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$");
    private final String nguoiDungFile = "C:\\Users\\admin\\OneDrive\\Tài liệu\\Data\\nguoidung.txt";
    private final String nhaTroFile = "C:\\Users\\admin\\OneDrive\\Tài liệu\\Data\\nhatro.txt";
    private final String danhGiaFile = "C:\\Users\\admin\\OneDrive\\Tài liệu\\Data\\danhgia.txt";

    public void addUser() {
        System.out.println("============ THÊM NGƯỜI DÙNG MỚI ===========");

        System.out.print("Nhập họ tên người dùng mới: ");
        String ten = sc.nextLine();
        System.out.print("Nhập giới tính (Nam/Nu): ");
        String gioiTinh = sc.nextLine();
        String phone;
        while (true) {
            System.out.print("Nhập vào số điện thoại: ");
            phone = sc.nextLine().trim();
            if (!PHONE_PATTERN.matcher(phone).matches()) {
                System.out.println("Số điện thoại không hợp lệ! Nhập lại.");
                continue;
            }
            break;
        }
        String email;
        while (true) {
            System.out.print("Nhập vào email: ");
            email = sc.nextLine().trim();
            if (!EMAIL_PATTERN.matcher(email).matches()) {
                System.out.println("Email không hợp lệ! Nhập lại.");
                continue;
            }
            break;
        }
        System.out.print("Nhập vào địa chỉ: ");
        String dc = sc.nextLine();
        System.out.print("Nhập vào quận: ");
        String quan = sc.nextLine();

        NguoiDung nd = new NguoiDung(ten, gioiTinh, phone, email, dc, quan);
        boolean result = nguoiDungDAO.addUser(nd);

        System.out.println(result ? "Đã thêm thành công!" : "Lỗi trong quá trình thêm!");
    }

    public void addNhaTro() {
        System.out.println("============ ĐĂNG THÔNG TIN NHÀ TRỌ MỚI ===========");

        try {
            System.out.print("Nhập mã loại: ");
            int maLoai = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập mã người đăng: ");
            int maND = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập giá tiền (VND): ");
            int gia = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập diện tích (m2): ");
            double dt = Double.parseDouble(sc.nextLine());
            System.out.print("Nhập vào quận: ");
            String quan = sc.nextLine();
            System.out.print("Nhập địa chỉ: ");
            String dc = sc.nextLine();
            System.out.println("Nhập mô tả: ");
            String mt = sc.nextLine();

            NhaTro nt = new NhaTro(maLoai, maND, gia, dt, quan, dc, mt);

            boolean result = nhaTroDAO.addNhaTro(nt);

            System.out.println(result ? "Đã thêm thành công!" : "Lỗi trong quá trình thêm!");

        } catch (Exception e) {
            System.out.println("Input lỗi");
        }
    }

    public void deleteByScore() {

        try {
            System.out.print("Nhập score (1-10): ");
            double score = Double.parseDouble(sc.nextLine());

            nhaTroDAO.deleteByScore(score);
            System.out.println("Tất cả nhà trọ có score thấp hơn " + score + " đã bị xóa!");

        } catch (Exception e) {
            System.out.println("Input lỗi");
        }
    }

    public void deleteByTime() {

        try {
            System.out.print("Nhập số ngày: ");
            int day = Integer.parseInt(sc.nextLine().trim());

            nhaTroDAO.deleteByTime(day);
            System.out.println("Tất cả nhà trọ cũ quá " + day + " ngày đã bị xóa!");

        } catch (Exception e) {
            System.out.println("Input lỗi");
        }
    }

    public void backup() {

        try {

            System.out.println("   ĐANG SAO LƯU DỮ LIỆU... ");

            List<NguoiDung> users = nguoiDungDAO.getAll();
            List<NhaTro> nhaTros = nhaTroDAO.getAll();
            List<DanhGia> danhGias = danhGiaDAO.getAll();

            writeFile(users, nguoiDungFile);
            writeFile(nhaTros, nhaTroFile);
            writeFile(danhGias, danhGiaFile);

            System.out.println("Backup thành công!");

            System.out.println("Users: " + users.size());
            System.out.println("NhaTro: " + nhaTros.size());
            System.out.println("DanhGia: " + danhGias.size());

        } catch (Exception e) {
            System.out.println("Error: Backup không thành công!");
        }

    }

    public void restore() {

        try {

            System.out.println("   ĐANG PHỤC HỒI DỮ LIỆU... ");

            List<NguoiDung> users = readFile(nguoiDungFile);
            List<NhaTro> nhaTros = readFile(nhaTroFile);
            List<DanhGia> danhGias = readFile(danhGiaFile);

            // restore theo thứ tự FK
            for (NguoiDung u : users) {
                nguoiDungDAO.insert(u);
            }

            for (NhaTro n : nhaTros) {
                nhaTroDAO.insert(n);
            }

            for (DanhGia d : danhGias) {
                danhGiaDAO.insert(d);
            }

            System.out.println("Restore thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private <T> void writeFile(List<T> data, String path) throws IOException {

        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(data);

        oos.close();
        fos.close();
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> readFile(String path) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);

        List<T> data = (List<T>) ois.readObject();

        ois.close();
        fis.close();

        return data;
    }

}
