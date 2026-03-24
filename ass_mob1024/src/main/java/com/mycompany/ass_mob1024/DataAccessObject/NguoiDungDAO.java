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
import com.mycompany.ass_mob1024.Model.NguoiDung;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {

    public boolean addUser(NguoiDung user){
        String sql = "{call sp_AddUsers(?,?,?,?,?,?)}";

        try(Connection conn = DBConnection.getConnection();
            CallableStatement cs = conn.prepareCall(sql)){

            cs.setString(1,user.getTenND());
            cs.setString(2,user.getGioiTinh());
            cs.setString(3,user.getDienThoai());
            cs.setString(4,user.getEmail());
            cs.setString(5,user.getDiaChi());
            cs.setString(6,user.getQuan());

            cs.execute();
            return true;
            
        }catch(SQLException e){
            return false;
        }
    }
    
    
    public List<NguoiDung> getAll() {

        List<NguoiDung> list = new ArrayList<>();
        String sql = "{call getdataND}";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {

                NguoiDung nd = new NguoiDung(
                        rs.getInt("MaND"),
                        rs.getString("TenND"),
                        rs.getString("GioiTinh"),
                        rs.getString("DienThoai"),
                        rs.getString("Email"),
                        rs.getString("DiaChi"),
                        rs.getString("Quan")
                );

                list.add(nd);
            }

        } catch (SQLException e) {
            System.err.println("NguoiDungDAO.getAll error: " + e.getMessage());
        }

        return list;
    }

    

    public boolean insert(NguoiDung nd) {
        String sql = "{call sp_InsertNguoiDung(?,?,?,?,?,?,?)}";
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, nd.getMaND());
            cs.setString(2, nd.getTenND());
            cs.setString(3, nd.getGioiTinh());
            cs.setString(4, nd.getDienThoai());
            cs.setString(5, nd.getEmail());
            cs.setString(6, nd.getDiaChi());
            cs.setString(7, nd.getQuan());
            cs.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("NguoiDungDAO.insert error: " + e.getMessage());
        }
        return false;
    }
}
