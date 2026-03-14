/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class EmployeeService {

    List<Employee> list = new ArrayList<>();

    public void add(Employee e){
        list.add(e);
    }

    public void showAll(){
        for(Employee e:list)
            System.out.println(e);
    }

    public Employee find(String id){

        for(Employee e:list){

            if(e.getId().equals(id))
                return e;

        }

        return null;
    }

    public void updateSalary(String id,double salary){

        Employee e = find(id);

        if(e!=null)
            e.setSalary(salary);
        else
            System.out.println("Khong tim thay");

    }
}
