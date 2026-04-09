/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6_mob1024.Service;

import com.mycompany.lab6_mob1024.Connect.DBConnect;
import com.mycompany.lab6_mob1024.Model.Tree;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */

public class TreeService {

    public List<Tree> findAll() {
        List<Tree> list = new ArrayList<>();
        String sql = "SELECT node_id, node_name, parent_id, [level] FROM tree ORDER BY node_id";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi lấy danh sách tree: " + e.getMessage());
        }
        return list;
    }

    public Tree findById(int id) {
        String sql = "SELECT node_id, node_name, parent_id, [level] FROM tree WHERE node_id = ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi tìm tree theo id: " + e.getMessage());
        }
        return null;
    }

    public boolean insert(Tree t) {
        String sql = "INSERT INTO tree(node_id, node_name, parent_id, [level]) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, t.getNodeId());
            ps.setString(2, t.getNodeName());

            if (t.getParentId() == null) {
                ps.setNull(3, Types.INTEGER);
            } else {
                ps.setInt(3, t.getParentId());
            }

            ps.setInt(4, t.getLevel());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi thêm tree: " + e.getMessage());
            return false;
        }
    }

    public boolean update(Tree t) {
        String sql = "UPDATE tree SET node_name = ?, parent_id = ?, [level] = ? WHERE node_id = ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, t.getNodeName());

            if (t.getParentId() == null) {
                ps.setNull(2, Types.INTEGER);
            } else {
                ps.setInt(2, t.getParentId());
            }

            ps.setInt(3, t.getLevel());
            ps.setInt(4, t.getNodeId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi cập nhật tree: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM tree WHERE node_id = ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi xóa tree: " + e.getMessage());
            return false;
        }
    }

    private Tree mapRow(ResultSet rs) throws SQLException {
        Tree t = new Tree();
        t.setNodeId(rs.getInt("node_id"));
        t.setNodeName(rs.getString("node_name"));

        int parentId = rs.getInt("parent_id");
        if (rs.wasNull()) {
            t.setParentId(null);
        } else {
            t.setParentId(parentId);
        }

        t.setLevel(rs.getInt("level"));
        return t;
    }
}