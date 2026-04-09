/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import entity.Employee;
import repository.EmployeeRepository;

/**
 *
 * @author ADMIN
 */
public class main {
    public static void main(String[] args) {
        EmployeeRepository repo = new EmployeeRepository();
        
        // Thêm thử 1 nhân viên
        repo.add(new Employee(1, "Nguyen Van A", 1000));
        
        // Tìm kiếm và hiển thị
        Employee found = repo.findById(1);
        if(found != null) {
            System.out.println("Tìm thấy thành công: " + found);
        } else {
            System.out.println("Tìm kiếm thất bại!");
        }
    }
}

