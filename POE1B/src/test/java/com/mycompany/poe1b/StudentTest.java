/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.poe1b;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class StudentTest {
    
    public StudentTest() {
    }

    @Test
    public void testStudentConstructor() {
        String[] courses = {"Math", "Science", "English"};
        double[] grades = {85.5, 90.0, 78.5};
        
        Student student = new Student("S001", "John Doe", "20", courses, grades);
        
        assertEquals("Student ID should match", "S001", student.StudentId);
        assertEquals("Student name should match", "John Doe", student.StudentName);
        assertEquals("Student age should match", "20", student.StudentAge);
        assertArrayEquals("Courses should match", courses, student.Courses);
        assertArrayEquals("Grades should match", grades, student.Grades, 0.01);
    }
    
    @Test
    public void testToString() {
        String[] courses = {"Math", "Science", "English"};
        double[] grades = {85.5, 90.0, 78.5};
        
        Student student = new Student("S001", "John Doe", "20", courses, grades);
        String result = student.toString();
        
        assertTrue("Should contain student ID", result.contains("S001"));
        assertTrue("Should contain student name", result.contains("John Doe"));
        assertTrue("Should contain student age", result.contains("20"));
        assertTrue("Should contain course names", result.contains("Math") && result.contains("Science") && result.contains("English"));
        assertTrue("Should contain grades", result.contains("85.5") && result.contains("90.0") && result.contains("78.5"));
    }
    
    // Helper method to calculate average (since it's not in Student class)
    private double calculateAverage(double[] grades) {
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        return total / grades.length;
    }
    
    // Helper method to get letter grade (since it's not in Student class)
    private String getLetterGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }
    
    @Test
    public void testCalculateAverage() {
        String[] courses = {"Math", "Science", "English"};
        double[] grades = {80.0, 90.0, 70.0}; // Average should be 80.0
        
        double average = calculateAverage(grades);
        assertEquals("Average should be 80.0", 80.0, average, 0.01);
    }
    
    @Test
    public void testGetLetterGrade() {
        // Test A grade (90+)
        double averageA = 91.67;
        assertEquals("A", getLetterGrade(averageA));
        
        // Test B grade (80-89)
        double averageB = 85.0;
        assertEquals("B", getLetterGrade(averageB));
        
        // Test C grade (70-79)
        double averageC = 75.0;
        assertEquals("C", getLetterGrade(averageC));
        
        // Test D grade (60-69)
        double averageD = 65.0;
        assertEquals("D", getLetterGrade(averageD));
        
        // Test F grade (<60)
        double averageF = 55.0;
        assertEquals("F", getLetterGrade(averageF));
    }
}