/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numbermultiplier;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class NumberMultiplier
{

    public static void main(String[] args) 
    {
        System.out.println("Number Multiplier");
        
        System.out.println("=== Number Multiplier ===");
        Scanner myScan = new Scanner(System.in);
        
        // Step 1: Get the name from the user
        System.out.print("Please enter your name: ");
        String name = myScan.nextLine();
        
        // Step 2: Get the number from the user
        System.out.print("Please enter your number: ");
        int num = myScan.nextInt();
        
        // Step 3: Multiply the number by 2
        int result = num * 2;
        
        // Step 4: Validate input (number should not be negative)
        if (num >= 0)
        {
            System.out.println(name + ", your total is: " + result);
        }
        else 
        {
            System.out.println("Error: the number should be greater than or equal to 0");
            return; // Stop execution if input is invalid
        }
        
        // Step 5: Check if result is single-digit, two-digit, or more
        if (result >= 10 && result <= 99)
        {
            System.out.println("The result is a two-digit number.");
        }
        else if (result < 10)
        {
            System.out.println("The result is a one-digit number.");
        }
        else 
        {
            System.out.println("The result has three or more digits.");
        }
    }
}