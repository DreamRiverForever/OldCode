package com.example.demo212;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class StudentBean {
    private List<Student> students=new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public static class Student {
        public Student(int i, String asd, String asd1) {
        }
    }
}
