/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentdetailsprinter;

/**
 *
 * @author RC_Student_lab
 */
public class StudentDetailsPrinter 
{
// Global variables for student information
    static String studentName = "Amahle";
    static String studentSurname = "Seima";
    
    public static void main(String[] args) 
    {
        System.out.println("Student Details Printer");
        
        System.out.println("=== Student Details Program ===");
        
        // Step 1: Call the method to display details
        displayDetails();
    }
    
    /**
     * Method to display student details
     */
    public static void displayDetails() 
    {
        // Local variable for campus name
        String campusName = "IIERC Pretoria Campus";
        
        // Step 2: Print student details
        System.out.println("My First Java Program at RC Pretoria Campus");
        System.out.println("Name        : " + studentName);
        System.out.println("Surname     : " + studentSurname);
        System.out.println("Campus Name : " + campusName);
    }  
}
 