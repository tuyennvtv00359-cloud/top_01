/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ass_mob1024.DataAccessObject;

/**
 *
 * @author PC
 */
import com.mycompany.ass_mob1024.Database.DBConnection;
import com.mycompany.ass_mob1024.Model.NhaTro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhaTroDAO {

    public List<NhaTro> viewAll() {
        List<NhaTro> list = new ArrayList<>();
        String sql = "{call sp_viewAll}";

        try (Connection conn = DBConnection.getConnection(); 
                CallableStatement cs = conn.prepareCall(sql)) {
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                NhaTro nt = new NhaTro();

                nt.setTenND(rs.getString("NguoiDang"));
                nt.setTenLoai(rs.getString("LoaiNha"));
                nt.setGiaTien(rs.getInt("GiaTien"));
                nt.setDienTich(rs.getFloat("DienTich"));
                nt.setQuan(rs.getString("Quan"));
                nt.setNgayDang(rs.getString("NgayDang"));
                nt.setScore(rs.getFloat("Score"));

                list.add(nt);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi trong quá trình lấy danh sách!");
        }
        return list;
    }

    public List<NhaTro> findList(
            String quan,
            Integer maLoai,
            Double dienTichMin,
            Double dienTichMax,
            Double giaMin,
            Double giaMax,
            Integer ngayDangTu) {

        List<NhaTro> list = new ArrayList<>();
        String sql = "{call sp_FindList(?,?,?,?,?,?,?)}";
        
        try (Connection conn = DBConnection.getConnection(); 
                CallableStatement cs = conn.prepareCall(sql)) {

            cs.setObject(1, quan);
            cs.setObject(2, maLoai);
            cs.setObject(3, dienTichMin);
            cs.setObject(4, dienTichMax);
            cs.setObject(5, giaMin);
            cs.setObject(6, giaMax);
            cs.setObject(7, ngayDangTu);

            ResultSet rs = cs.executeQuery();
            while (rs.next()) {

                NhaTro nt = new NhaTro();

                nt.setMaNT(rs.getInt("MaNT"));
                nt.setQuan(rs.getString("Quan"));
                nt.setGiaTien(rs.getInt("GiaTien"));
                nt.setDienTich(rs.getDouble("DienTich"));
                nt.setScore(rs.getDouble("Score"));
                nt.setNgayDang(rs.getString("NgayDang"));
                list.add(nt);
            }

        } catch (SQLException e) {
            System.out.println("findList error: " + e.getMessage());
        }
        return list;
    }

   
    public void findByMa(int maNT) {
        String sql = "{call sp_FindByMa(?)}";

        try (Connection conn = DBConnection.getConnection(); 
                CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, maNT);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                String tl = rs.getString("TenLoai");
                int gia = rs.getInt("GiaTien");
                float dt = rs.getFloat("DienTich");
                String quan = rs.getString("Quan");
                String dc1 = rs.getString("DiaChi");
                String mt = rs.getString("MoTa");
                String nd = rs.getString("NgayDang");
                String tnd = rs.getString("TenND");
                String gt = rs.getString("GioiTinh");
                String phone = rs.getString("DienThoai");
                String email = rs.getString("Email");
                String dc2 = rs.getString("DiaChiNguoiDang");
                int like = rs.getInt("LikeCount");
                float score = rs.getFloat("Score");

                System.out.printf("%-30s %35s%n","Cho thuê nhà ở tại:",dc1+" - "+quan);
                System.out.printf("%-30s %35s%n","Loại:",tl);
                System.out.printf("%-30s %35s%n","Diện tích:",dt+" m2");
                System.out.printf("%-30s %35s%n","Giá ở theo tháng:",gia+" VND");
                System.out.printf("%-30s %35s%n","Thời gian đăng cụ thể:",nd);
                System.out.printf("%-30s %35s%n","Mô tả:",mt);
                System.out.printf("%-30s %35s%n","Điểm đánh giá:",score+"/10  ("+like+" Like)");
                System.out.printf("---------------------------------------------------------------------%n");
                System.out.printf("   -> Thông tin người liên hệ:%n");
                System.out.printf("%-30s %35s%n",tnd,"Giới tính: "+gt);
                System.out.printf("%-30s %35s%n","Phone: "+phone,"Email: "+email);
                System.out.printf("%-30s %35s%n","Địa chỉ liên hệ:",dc2+" - "+quan);
            } else {
                System.out.println("Không tìm thấy nhà trọ có mã: " + maNT);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public List<NhaTro> findByID(int maND) {
        List<NhaTro> list = new ArrayList<>();
        String sql = "{call sp_GetNTByID(?)}";
        
        try (Connection conn = DBConnection.getConnection();
                CallableStatement cs = conn.prepareCall(sql)) {
            
            cs.setInt(1, maND);
            
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {

                NhaTro nt = new NhaTro();

                nt.setMaNT(rs.getInt("MaNT"));
                nt.setTenLoai(rs.getString("TenLoai")); 
                nt.setGiaTien(rs.getInt("GiaTien"));
                nt.setDienTich(rs.getDouble("DienTich"));
                nt.setQuan(rs.getString("Quan"));
                nt.setDiaChi(rs.getString("DiaChi"));
                nt.setNgayDang(rs.getString("NgayDang"));
                nt.setScore(rs.getDouble("Score"));
                nt.setTrangThai(rs.getString("TrangThai"));
                list.add(nt);
            }
        } catch (SQLException e) {
            System.out.println("Lấy danh sách không thành công!" + e.getMessage());
        }
        return list;
    }


    public List<NhaTro> viewTopScore() {

        List<NhaTro> list = new ArrayList<>();
        String sql = "{call sp_ViewTopScore}";

        try (Connection conn = DBConnection.getConnection(); 
                CallableStatement cs = conn.prepareCall(sql)) {
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                NhaTro nt = new NhaTro();
                nt.setMaNT(rs.getInt("MaNT"));
                nt.setQuan(rs.getString("Quan"));
                nt.setGiaTien(rs.getInt("GiaTien"));
                nt.setScore(rs.getDouble("Score"));
                list.add(nt);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }


    public boolean addNhaTro(NhaTro nt) {

        String sql = "{call sp_AddNhaTro(?,?,?,?,?,?,?)}";

        try (Connection conn = DBConnection.getConnection(); 
                CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, nt.getMaLoai());
            cs.setInt(2, nt.getMaND());
            cs.setDouble(3, nt.getGiaTien());
            cs.setDouble(4, nt.getDienTich());
            cs.setString(5, nt.getQuan());
            cs.setString(6, nt.getDiaChi());
            cs.setString(7, nt.getMoTa());

            return cs.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    public void deleteByScore(double score) {

        String sql = "{call sp_deleteByScore(?)}";

        try (Connection conn = DBConnection.getConnection();
                CallableStatement cs = conn.prepareCall(sql)) {

            cs.setDouble(1, score);
            cs.execute();
            System.out.println("Delete thành công!");

        } catch (SQLException e) {
            System.out.println("Error: Delete thất bại!");
        }
    }


    public void deleteByTime(int day) {

        String sql = "{call sp_deleteByTime(?)}";

        try (Connection conn = DBConnection.getConnection(); 
                CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, day);
            cs.execute();
            System.out.println("Delete thành công!");

        } catch (SQLException e) {
            System.out.println("Error: Delete thất bại!");
        }
    }
    
    public void deleteByMa(int maNT) {
        String sql = "delete from NhaTro where MaNT = ?";
        
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, maNT);
            ps.execute();
            System.out.println("Xóa thành công");
        } catch (SQLException e) {
            System.out.println("Xóa không thành công" + e.getMessage());
        }
    }
    
    
    public List<NhaTro> getAll() {

        List<NhaTro> list = new ArrayList<>();

        String sql = "{call sp_getdataNT}";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {

                NhaTro nt = new NhaTro();

                nt.setMaNT(rs.getInt("MaNT"));
                nt.setMaLoai(rs.getInt("MaLoai"));
                nt.setMaND(rs.getInt("MaND"));
                nt.setGiaTien(rs.getInt("GiaTien"));
                nt.setDienTich(rs.getDouble("DienTich"));
                nt.setQuan(rs.getString("Quan"));
                nt.setDiaChi(rs.getString("DiaChi"));
                nt.setMoTa(rs.getString("MoTa"));
                nt.setNgayDang(rs.getString("NgayDang"));
                nt.setLikeCount(rs.getInt("LikeCount"));
                nt.setDislikeCount(rs.getInt("DislikeCount"));
                nt.setScore(rs.getFloat("Score"));
                nt.setTrangThai(rs.getString("TrangThai"));

                list.add(nt);
            }

        } catch (SQLException e) {
            System.err.println("NhaTroDAO.getAll error: " + e.getMessage());
        }

        return list;
    }

    

    public boolean insert(NhaTro nt) {

        String sql = "{call sp_InsertNhaTro(?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, nt.getMaNT());
            cs.setInt(2, nt.getMaLoai());
            cs.setInt(3, nt.getMaND());
            cs.setDouble(4, nt.getGiaTien());
            cs.setDouble(5, nt.getDienTich());
            cs.setString(6, nt.getQuan());
            cs.setString(7, nt.getDiaChi());
            cs.setString(8, nt.getMoTa());
            cs.setString(9, nt.getNgayDang());
            cs.setInt(10, nt.getLikeCount());
            cs.setInt(11, nt.getDislikeCount());
            cs.setFloat(12, (float) nt.getScore());
            cs.setString(13, nt.getTrangThai());

            cs.execute();
            return true;

        } catch (SQLException e) {
            System.err.println("NhaTroDAO.insert error: " + e.getMessage());
        }

        return false;
    }
    
    public void khoiPhuc() {
        
        String sql = "{call sp_KhoiPhuc}";
        
        try (Connection conn = DBConnection.getConnection();
                CallableStatement cs = conn.prepareCall(sql)) {
            cs.execute();
            System.out.println("Khôi phục thành công!");
        } catch (SQLException e) {
            System.out.println("Khôi phục không thành công!");
        }
    }
}
