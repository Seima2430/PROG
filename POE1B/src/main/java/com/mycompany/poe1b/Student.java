/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe1b;

/**
 *
 * @author RC_Student_lab
 */
public class Student 
{
     public String StudentId;
    public String StudentName;
    public String StudentAge;
    public String[] Courses;
    public double[] Grades;
    
    public Student(String studentId, String studentName, String studentAge, 
                  String[] courses, double[] grades) {
        this.StudentId = studentId;
        this.StudentName = studentName;
        this.StudentAge = studentAge;
        this.Courses = courses;
        this.Grades = grades;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------------------\n");
        sb.append("Student ID: ").append(StudentId).append("\n");
        sb.append("Student Name: ").append(StudentName).append("\n");
        sb.append("Student Age: ").append(StudentAge).append("\n");
        
        sb.append("Courses and Grades:\n");
        for (int i = 0; i < Courses.length; i++) {
            sb.append("  ").append(Courses[i]).append(": ").append(Grades[i]).append("\n");
        }
        
        return sb.toString();
    }

    double calculateAverage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

