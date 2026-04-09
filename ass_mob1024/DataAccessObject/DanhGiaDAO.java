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
import com.mycompany.ass_mob1024.Model.DanhGia;
import com.mycompany.ass_mob1024.Model.TrangThai;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DanhGiaDAO {

    public boolean addDanhGia(DanhGia dg) {
        String sql = "{call sp_AddDanhGia(?,?,?,?)}";

        try (Connection conn = DBConnection.getConnection(); 
                CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, dg.getMaND());
            cs.setInt(2, dg.getMaNT());
            cs.setString(3, dg.getTrangThai().name());
            cs.setString(4, dg.getNoiDung());
            return cs.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    public List<DanhGia> viewRating(int maNT) {

        List<DanhGia> list = new ArrayList<>();
        String sql = "{call sp_ViewRating(?)}";

        try (Connection conn = DBConnection.getConnection(); 
                CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, maNT);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                DanhGia dg = new DanhGia();
                dg.setTenND(rs.getString("TenND"));
                dg.setTrangThai(TrangThai.valueOf(rs.getString("TrangThai")));
                dg.setNoiDung(rs.getString("NoiDung"));
                list.add(dg);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    
    public List<DanhGia> getAll() {

        List<DanhGia> list = new ArrayList<>();

        String sql = "{call sp_getdataDG}";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {

                DanhGia dg = new DanhGia();

                dg.setMaDG(rs.getInt("MaDG"));
                dg.setMaND(rs.getInt("MaND"));
                dg.setMaNT(rs.getInt("MaNT"));

                dg.setTrangThai(TrangThai.valueOf(rs.getString("TrangThai")));

                dg.setNoiDung(rs.getString("NoiDung"));
                dg.setNgayDanhGia(rs.getString("NgayDanhGia"));

                list.add(dg);
            }

        } catch (SQLException e) {
            System.err.println("DanhGiaDAO.getAll error: " + e.getMessage());
        }

        return list;
    }


    public boolean insert(DanhGia dg) {

        String sql = "{call sp_InsertDanhGia(?,?,?,?,?,?)}";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, dg.getMaDG());
            cs.setInt(2, dg.getMaND());
            cs.setInt(3, dg.getMaNT());
            cs.setString(4, dg.getTrangThai().name());
            cs.setString(5, dg.getNoiDung());
            cs.setString(6, dg.getNgayDanhGia());

            cs.execute();

            return true;

        } catch (SQLException e) {
            System.err.println("DanhGiaDAO.insert error: " + e.getMessage());
        }

        return false;
    }
}
