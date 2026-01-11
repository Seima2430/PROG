/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe1b;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class StudentManager 
{
    private final ArrayList<Student> studentList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    
    public void AddStudent() {
        System.out.println("ADD A NEW STUDENT");
        System.out.println("*************************");
        System.out.print("Enter the student id: ");
        String id = scanner.nextLine();
        
        // Check if student ID already exists
        for (Student s : studentList) {
            if (s.StudentId.equals(id)) {
                System.out.println("Student with this ID already exists!");
                return;
            }
        }
        
        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter the student age: ");
        String age = scanner.nextLine();
        
        // Create courses and grades arrays
        String[] courses = new String[3];
        double[] grades = new double[3];
        
        System.out.println("Enter course names and grades for 3 courses:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter course name " + (i+1) + ": ");
            courses[i] = scanner.nextLine();
            
            System.out.print("Enter grade for " + courses[i] + " (0-100): ");
            String gradeInput = scanner.nextLine();
            
            // Validate grade
            while (!isValidGrade(gradeInput)) {
                System.out.println("Invalid grade! Please enter a number between 0 and 100.");
                System.out.print("Enter grade for " + courses[i] + " (0-100): ");
                gradeInput = scanner.nextLine();
            }
            
            grades[i] = Double.parseDouble(gradeInput);
        }
        
        studentList.add(new Student(id, name, age, courses, grades));
        System.out.println("Student added successfully!");
    }
    
    public void SearchStudent() {
        System.out.print("Enter the student id to search: ");
        String id = scanner.nextLine();
        
        Student found = null;
        for (Student s : studentList) {
            if (s.StudentId.equals(id)) {
                found = s;
                break;
            }
        }
        
        if (found != null) {
            System.out.println(found.toString());
        } else {
            System.out.println("----------------------------------------");
            System.out.println("Student with ID: " + id + " was not found!");
            System.out.println("----------------------------------------");
        }
    }
    
    public void UpdateStudent() {
        System.out.print("Enter the student id to update: ");
        String id = scanner.nextLine();
        
        Student found = null;
        for (Student s : studentList) {
            if (s.StudentId.equals(id)) {
                found = s;
                break;
            }
        }
        
        if (found != null) {
            System.out.print("Enter new student name (current: " + found.StudentName + "): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                found.StudentName = name;
            }
            
            System.out.print("Enter new student age (current: " + found.StudentAge + "): ");
            String age = scanner.nextLine();
            if (!age.isEmpty()) {
                found.StudentAge = age;
            }
            
            System.out.println("Update grades for courses:");
            for (int i = 0; i < found.Courses.length; i++) {
                System.out.print("Enter new grade for " + found.Courses[i] + 
                                 " (current: " + found.Grades[i] + "): ");
                String gradeInput = scanner.nextLine();
                
                if (!gradeInput.isEmpty()) {
                    while (!isValidGrade(gradeInput)) {
                        System.out.println("Invalid grade! Please enter a number between 0 and 100.");
                        System.out.print("Enter new grade for " + found.Courses[i] + ": ");
                        gradeInput = scanner.nextLine();
                    }
                    
                    found.Grades[i] = Double.parseDouble(gradeInput);
                }
            }
            
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student with ID: " + id + " was not found!");
        }
    }
    
    public void DeleteStudent() {
        System.out.print("Enter the student id to delete: ");
        String id = scanner.nextLine();
        
        Student found = null;
        for (Student s : studentList) {
            if (s.StudentId.equals(id)) {
                found = s;
                break;
            }
        }
        
        if (found != null) {
            System.out.print("Are you sure you want to delete student " + id + 
                             " from the system? Yes (y) to delete: ");
            String confirm = scanner.nextLine();
            
            if (confirm.equalsIgnoreCase("y")) {
                studentList.remove(found);
                System.out.println("---------------------------------------");
                System.out.println("Student with ID: " + id + " WAS deleted!");
                System.out.println("---------------------------------------");
            }
        } else {
            System.out.println("Student with ID: " + id + " was not found!");
        }
    }
    
    public void StudentReport() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("STUDENT GRADE REPORT");
            System.out.println("**************************************");
            
            for (Student s : studentList) {
                System.out.println(s.toString());
                
                // Calculate and display average grade
                double total = 0;
                for (double grade : s.Grades) {
                    total += grade;
                }
                double average = total / s.Grades.length;
                
                System.out.println("Average Grade: " + String.format("%.2f", average));
                
                // Determine letter grade
                String letterGrade;
                if (average >= 90) letterGrade = "A";
                else if (average >= 80) letterGrade = "B";
                else if (average >= 70) letterGrade = "C";
                else if (average >= 60) letterGrade = "D";
                else letterGrade = "F";
                
                System.out.println("Letter Grade: " + letterGrade);
                System.out.println("----------------------------------------");
            }
        }
    }
    
    public void ExitApplication() {
        System.out.println("Exiting application... Goodbye!");
        System.exit(0);
    }
    
    private boolean isValidGrade(String gradeStr) {
        try {
            double grade = Double.parseDouble(gradeStr);
            return grade >= 0 && grade <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
    


