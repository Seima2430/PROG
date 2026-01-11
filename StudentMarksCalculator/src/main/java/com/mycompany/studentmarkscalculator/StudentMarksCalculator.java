/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmarkscalculator;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class StudentMarksCalculator 
{

    public static void main(String[] args) 
    {
        System.out.println("Student Marks Calculator");
        System.out.println("=== Student Marks Calculator ===");
        Scanner myScan = new Scanner(System.in);

        // Input: student's personal details
        System.out.print("Enter student's first name: ");
        String name = myScan.nextLine();

        System.out.print("Enter student's surname: ");
        String surname = myScan.nextLine();

        // Input: student's test marks
        System.out.print("Enter mark for Test 1: ");
        double test1 = myScan.nextDouble();

        System.out.print("Enter mark for Test 2: ");
        double test2 = myScan.nextDouble();

        System.out.print("Enter mark for Test 3: ");
        double test3 = myScan.nextDouble();

        // Create a Student object with the provided details
        Student student = new Student(name, surname, test1, test2, test3);

        // Calculate average mark using Student class method
        double average = student.calculateAverage();

        // Output results
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + student.getStName());
        System.out.println("Surname: " + student.getStSurname());
        System.out.println("Test 1: " + student.getTest1());
        System.out.println("Test 2: " + student.getTest2());
        System.out.println("Test 3: " + student.getTest3());
        System.out.printf("Average: %.2f\n", average);
    }
}

/**
 * Student class that holds student details and test scores,
 * with methods to access data and calculate average.
 */
class Student 
{
    // Private instance variables for student name, surname, and test marks
    private String stName;
    private String stSurname;
    private double test1, test2, test3;

    // Constructor: initializes student object with given values
    public Student(String stName, String stSurname, double test1, double test2, double test3) 
    {
        this.stName = stName;
        this.stSurname = stSurname;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
    }

    // Getters (accessor methods)
    public String getStName() { return stName; }
    public String getStSurname() { return stSurname; }
    public double getTest1() { return test1; }
    public double getTest2() { return test2; }
    public double getTest3() { return test3; }

    // Setters (mutator methods)
    public void setStName(String stName) { this.stName = stName; }
    public void setStSurname(String stSurname) { this.stSurname = stSurname; }
    public void setTest1(double test1) { this.test1 = test1; }
    public void setTest2(double test2) { this.test2 = test2; }
    public void setTest3(double test3) { this.test3 = test3; }

    // Method to calculate the average of three test marks
    public double calculateAverage() 
    {
        return (test1 + test2 + test3) / 3;
    }
}
