/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.Student;
import enumm.StudentType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class StudentService {

    List<Student> list = new ArrayList<>();

    public void fakeData(){

        list.add(new Student("S1","An",StudentType.REGULAR));
        list.add(new Student("S2","Binh",StudentType.PART_TIME));
        list.add(new Student("S3","Cuong",StudentType.INTERNATIONAL));
        list.add(new Student("S4","Dung",StudentType.REGULAR));
        list.add(new Student("S5","Lan",StudentType.PART_TIME));
        list.add(new Student("S6","Huy",StudentType.INTERNATIONAL));

    }

    public void showAll(){
        for(Student s:list)
            System.out.println(s);
    }

    public void showByType(StudentType type){

        for(Student s:list){
            if(s.getType()==type)
                System.out.println(s);
        }

    }

    public void count(){

        Map<StudentType,Integer> map = new HashMap<>();

        for(Student s:list){
            map.put(s.getType(),
                    map.getOrDefault(s.getType(),0)+1);
        }

        for(Map.Entry<StudentType,Integer> e:map.entrySet()){
            System.out.println(e.getKey()+" : "+e.getValue());
        }

    }
}
