/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6_mob1024.Service;

import com.mycompany.lab6_mob1024.Connect.DBConnect;
import com.mycompany.lab6_mob1024.Model.Student;
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

public class StudentService {

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT student_id, student_name, gender, gpa FROM student ORDER BY student_id";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi lấy danh sách student: " + e.getMessage());
        }
        return list;
    }

    public Student findById(int id) {
        String sql = "SELECT student_id, student_name, gender, gpa FROM student WHERE student_id = ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi tìm student theo id: " + e.getMessage());
        }
        return null;
    }

    public boolean insert(Student s) {
        String sql = "INSERT INTO student(student_id, student_name, gender, gpa) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, s.getStudentId());
            ps.setString(2, s.getStudentName());
            ps.setString(3, s.getGender());

            if (s.getGpa() == null) {
                ps.setNull(4, Types.FLOAT);
            } else {
                ps.setFloat(4, s.getGpa());
            }

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi thêm student: " + e.getMessage());
            return false;
        }
    }

    public boolean update(Student s) {
        String sql = "UPDATE student SET student_name = ?, gender = ?, gpa = ? WHERE student_id = ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getStudentName());
            ps.setString(2, s.getGender());

            if (s.getGpa() == null) {
                ps.setNull(3, Types.FLOAT);
            } else {
                ps.setFloat(3, s.getGpa());
            }

            ps.setInt(4, s.getStudentId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi cập nhật student: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM student WHERE student_id = ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Lỗi xóa student: " + e.getMessage());
            return false;
        }
    }

    private Student mapRow(ResultSet rs) throws SQLException {
        Student s = new Student();
        s.setStudentId(rs.getInt("student_id"));
        s.setStudentName(rs.getString("student_name"));
        s.setGender(rs.getString("gender"));

        float gpaValue = rs.getFloat("gpa");
        if (rs.wasNull()) {
            s.setGpa(null);
        } else {
            s.setGpa(gpaValue);
        }
        return s;
    }
}

