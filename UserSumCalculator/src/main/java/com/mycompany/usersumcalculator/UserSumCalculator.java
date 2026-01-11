/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.usersumcalculator;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class UserSumCalculator 
{

    public static void main(String[] args) 
    {
        System.out.println("User Sum Calculator");
        
        System.out.println("=== User Sum Calculator ===");
        
        // Step 1: Create a Scanner object to read input
        Scanner myScanner = new Scanner(System.in);
        
        // Step 2: Get the user's name
        System.out.print("Please enter your name: ");
        String name = myScanner.nextLine();
        System.out.println("Hi " + name); // Greeting message
        
        // Step 3: Get two integer values from the user
        System.out.print("Please enter your first number: ");
        int num1 = myScanner.nextInt();
        
        System.out.print("Please enter your second number: ");
        int num2 = myScanner.nextInt();
        
        // Step 4: Calculate the sum of the two integers
        int sum = num1 + num2;
        
        // Step 5: Display the result
        System.out.println("Hi " + name + ", your total is: " + sum);
    }
}