/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe1b;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Main 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        
        while (true) {
            System.out.println("STUDENT GRADE MANAGEMENT SYSTEM");
            System.out.println("**************************************");
            System.out.print("Enter (1) to launch menu or any other key to exit: ");
            String choice = scanner.nextLine();
            
            if (!choice.equals("1")) {
                studentManager.ExitApplication();
            }
            
            System.out.println("1. Add a new student");
            System.out.println("2. Search for a student");
            System.out.println("3. Update student grade");
            System.out.println("4. Delete a student");
            System.out.println("5. Print student grade report");
            System.out.println("6. Exit Application");
            System.out.print("Please select one of the following menu items: ");
            String menuChoice = scanner.nextLine();
            
            switch (menuChoice) {
                case "1" -> studentManager.AddStudent();
                case "2" -> studentManager.SearchStudent();
                case "3" -> studentManager.UpdateStudent();
                case "4" -> studentManager.DeleteStudent();
                case "5" -> studentManager.StudentReport();
                case "6" -> studentManager.ExitApplication();
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
    

