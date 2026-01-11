/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmarks2darray;

/**
 *
 * @author RC_Student_lab
 */
public class StudentMarks2DArray 
{

    public static void main(String[] args) 
    {
        System.out.println("Student Marks 2D Array!");
        
        // Greeting message
        System.out.println("Hello Seima");
        
        // Step 1: Declare number of students and subjects
        int students = 3;
        int subjects = 4;
        
        // Step 2: Declare and initialize a 2D array of student marks
        // Each row represents a student, and each column a subject
        int [][] marks = 
        {
            {85, 78, 92, 70},   // Student 1 marks
            {66, 74, 80, 88},   // Student 2 marks
            {90, 91, 89, 93}    // Student 3 marks
        };
        
        // Step 3: Display the marks in a structured format
        System.out.println("--- Student Marks Table ---");
        
        // Outer loop → iterates through students (rows)
        for (int i = 0; i < students; i++) 
        {
            System.out.println("Student " + (i + 1) + ":");
            
            // Inner loop → iterates through subjects (columns)
            for (int j = 0; j < subjects; j++) 
            {
                System.out.println("  Subject " + (j + 1) + ": " + marks[i][j]);
            }
            
            // Blank line after each student for readability
            System.out.println();
        }
    }
}

