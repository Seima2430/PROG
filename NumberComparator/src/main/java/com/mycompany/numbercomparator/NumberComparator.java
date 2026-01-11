/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numbercomparator;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class NumberComparator 
{

    public static void main(String[] args) 
    {
        System.out.println("Number Comparator ");
        System.out.println("=== Number Comparator ===");
        Scanner myScan = new Scanner(System.in);
        
        // Step 1: Get the user's name
        System.out.print("Please enter your name: ");
        String name = myScan.nextLine();
        
        // Step 2: Get two numbers from the user
        System.out.print("Please enter the first number (num1): ");
        int num1 = myScan.nextInt();
        
        System.out.print("Please enter the second number (num2): ");
        int num2 = myScan.nextInt();
        
        // Step 3: Calculate the sum
        int sum = num1 + num2;
        
        // Step 4: Display the sum
        System.out.println("Hi " + name + ", the sum is: " + sum);
        
        // Step 5: Compare the two numbers
        if (num1 > num2)
        {
            System.out.println("Num1 is greater than Num2"); 
        }
        else if (num2 > num1)
        {
            System.out.println("Num1 is smaller than Num2"); 
        }
        else 
        {
            System.out.println("Both Num1 and Num2 are equal");
        }     
    }
}
