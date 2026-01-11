/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.evennumberssumaverage;

/**
 *
 * @author RC_Student_lab
 */
public class EvenNumbersSumAverage 
{

    public static void main(String[] args) 
    {
        System.out.println("Even Numbers Sum Average");
         System.out.println("=== Even Numbers Sum and Average ===");
        
        int sum = 0;          // To store the sum of even numbers
        int average;          // To store the average
        int count = 0;        // To count how many numbers are added
        
        // Step 1: Loop through even numbers from 2 to 20
        for (int i = 2; i <= 20; i += 2)
        {
            System.out.println("Now i is: " + i);
            sum += i;      // Add the current even number to sum
            count++;       // Increment the counter
        }
        
        // Step 2: Calculate the average
        average = sum / count;
        
        // Step 3: Display results
        System.out.println("The sum is: " + sum);
        System.out.println("The average is: " + average);        
    }
}

