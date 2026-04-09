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
import com.mycompany.ass_mob1024.Database.DBConnection;
import com.mycompany.ass_mob1024.Model.DanhGia;
import com.mycompany.ass_mob1024.Model.NhaTro;
import com.mycompany.ass_mob1024.Model.TrangThai;
import com.mycompany.ass_mob1024.Model.UserDB;
import com.mycompany.ass_mob1024.Model.UserID;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class Service {

    protected final Scanner sc = new Scanner(System.in);
    protected final NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
    protected final NhaTroDAO nhaTroDAO = new NhaTroDAO();
    protected final DanhGiaDAO danhGiaDAO = new DanhGiaDAO();
    private final String DataBaseFile = "C:\\Users\\PC\\OneDrive\\Documents\\FPT Polyschool\\JavaData\\database.txt";
    
    public int getUserID(String dt) {
        List<UserID> list = nguoiDungDAO.getUserList();
        
        for (UserID user : list) {
            if (user.dt().trim().equals(dt)){
                return user.id();
            }
        }
        return -1;
    }

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
    
  
    public void addNhaTro() {
        System.out.println("============ ĐĂNG THÔNG TIN NHÀ TRỌ MỚI ===========");

        try {
            System.out.print("Mã loại: ");
            int maLoai = Integer.parseInt(sc.nextLine());
            System.out.print("Mã người đăng: ");
            int maND = Integer.parseInt(sc.nextLine());
            System.out.print("Giá tiền (VND): ");
            int gia = Integer.parseInt(sc.nextLine());
            System.out.print("Diện tích (m2): ");
            double dt = Double.parseDouble(sc.nextLine());
            System.out.print("Quận: ");
            String quan = sc.nextLine();
            System.out.print("Địa chỉ: ");
            String dc = sc.nextLine();
            System.out.println("Mô tả: ");
            String mt = sc.nextLine();

            NhaTro nt = new NhaTro(maLoai, maND, gia, dt, quan, dc, mt);

            boolean result = nhaTroDAO.addNhaTro(nt);

            System.out.println(result ? "Đã thêm thành công!" : "Lỗi trong quá trình thêm!");

        } catch (Exception e) {
            System.out.println("Input lỗi");
        }
    }
    
    public void addNhaTro(int maND) {
        System.out.println("============ ĐĂNG THÔNG TIN NHÀ TRỌ MỚI ===========");

        try {
            System.out.print("Mã loại: ");
            int maLoai = Integer.parseInt(sc.nextLine());
            System.out.print("Giá tiền (VND): ");
            int gia = Integer.parseInt(sc.nextLine());
            System.out.print("Diện tích (m2): ");
            double dt = Double.parseDouble(sc.nextLine());
            System.out.print("Quận: ");
            String quan = sc.nextLine();
            System.out.print("Địa chỉ: ");
            String dc = sc.nextLine();
            System.out.println("Mô tả: ");
            String mt = sc.nextLine();

            NhaTro nt = new NhaTro(maLoai, maND, gia, dt, quan, dc, mt);

            boolean result = nhaTroDAO.addNhaTro(nt);

            System.out.println(result ? "Đã thêm thành công!" : "Lỗi trong quá trình thêm!");

        } catch (Exception e) {
            System.out.println("Input lỗi");
        }
    }
    
      
    private void writeDB(UserDB data, String path) throws IOException {

        try (FileOutputStream fos = new FileOutputStream(path); 
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            
            oos.writeObject(data);
            
        }
    }

    @SuppressWarnings("unchecked")
    private UserDB readDB(String path) throws IOException, ClassNotFoundException {

        UserDB data;
        try (FileInputStream fis = new FileInputStream(path); 
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            data = (UserDB) ois.readObject();
        }

        return data;
    }
    

    public void getDBInfo() {
        while (true) {
            try {
                System.out.print("Chọn Database để kết nối (1.Database trước đó, 2.Database Server, 3.Database Local):");
                int choice = Integer.parseInt(sc.nextLine().trim());
                switch (choice) {
                    case 1 -> {
                        UserDB user = readDB(DataBaseFile);
                        DBConnection.setHOSTNAME(user.getHostName());
                        DBConnection.setPORT(user.getPort());
                        DBConnection.setDBNAME(user.getDbName());
                        DBConnection.setUSER(user.getUserName());
                        DBConnection.setPASSWORD(user.getPassword());
                        System.out.println("Kết nối thành công!");
                    }
                    case 2 -> {                        
                        System.out.print("Nhập portname(enter bỏ qua): ");
                        String a = sc.nextLine().trim();
                        String port = a.isEmpty() ? a : "1433";
                        System.out.print("Nhập tên database: ");
                        String dbname = sc.nextLine().trim();                        
                        System.out.print("Nhập username: ");
                        String username = sc.nextLine().trim();                      
                        System.out.print("Nhập password: ");
                        String password = sc.nextLine().trim();
                        
                        DBConnection.setHOSTNAME("s103-d186.interdata.vn");
                        DBConnection.setPORT(port);
                        DBConnection.setDBNAME(dbname);
                        DBConnection.setUSER(username);
                        DBConnection.setPASSWORD(password);
                        
                        UserDB user = new UserDB("s103-d186.interdata.vn",port,dbname,username,password);
                        writeDB(user,DataBaseFile);
                        System.out.println("Kết nối thành công!");
                    }
                    case 3 -> {
                        System.out.print("Nhập portname(enter bỏ qua): ");
                        String a = sc.nextLine().trim();
                        String port = a.isEmpty() ? a : "1433";
                        System.out.print("Nhập tên database: ");
                        String dbname = sc.nextLine().trim();                        
                        System.out.print("Nhập username: ");
                        String username = sc.nextLine().trim();                      
                        System.out.print("Nhập password: ");
                        String password = sc.nextLine().trim();
                        
                        DBConnection.setHOSTNAME("localhost");
                        DBConnection.setPORT(port);
                        DBConnection.setDBNAME(dbname);
                        DBConnection.setUSER(username);
                        DBConnection.setPASSWORD(password); 
                        
                        UserDB user = new UserDB("localhost",port,dbname,username,password);
                        writeDB(user,DataBaseFile);
                        System.out.println("Kết nối thành công!");
                    }
                    case 4 -> {
                        DBConnection.setHOSTNAME("s103-d186.interdata.vn");
                        DBConnection.setPORT("1433");
                        DBConnection.setDBNAME("fps");
                        DBConnection.setUSER("fps_thientq");
                        DBConnection.setPASSWORD("T8^Y2W7n~h9mJu");
                        
                        UserDB user = new UserDB("s103-d186.interdata.vn","1433","fps","fps_thientq","T8^Y2W7n~h9mJu");
                        writeDB(user,DataBaseFile);
                        System.out.println("Kết nối thành công!");
                    }
                    default -> {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Lỗi trong quá trình lấy kết nối!" + e.getMessage());
            }
        }
    }

}

