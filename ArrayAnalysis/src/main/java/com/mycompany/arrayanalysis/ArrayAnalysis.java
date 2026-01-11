/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arrayanalysis;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class ArrayAnalysis 
{

    public static void main(String[] args) 
    {
        System.out.println("Array Analysis");
          System.out.println("=== Array Analysis Program ===");
        
        int[] nums = new int[10];       // Array to store 10 integers
        int oddNums = 0, evenNums = 0;
        int largestNum;
        int sumGreater50 = 0;
        
        Scanner myNums = new Scanner(System.in);
        System.out.println("Please enter 10 integers of your choice:");
        
        // Step 1: Get 10 integers from the user
        for (int i = 0; i < 10; i++)
        {
            nums[i] = myNums.nextInt(); // Store each input in the array
        }
        
        // Step 2: Assume the first element is the largest initially
        largestNum = nums[0];
        
        // Step 3: Analyze the array
        for (int j = 0; j < 10; j++)
        {
            // Count even and odd numbers
            if (nums[j] % 2 == 0)
            {
               evenNums++;
            }
            else
            {
               oddNums++; 
            }
            
            // Find the largest number
            if (nums[j] > largestNum)
            {
                largestNum = nums[j];
            }
            
            // Sum numbers greater than 50
            if (nums[j] > 50)
            {
                sumGreater50 += nums[j];
            }
        }
        
        // Step 4: Display results
        System.out.println("There are " + evenNums + " even numbers.");
        System.out.println("There are " + oddNums + " odd numbers.");
        System.out.println("The largest number in the array is " + largestNum);
        System.out.println("The sum of all numbers greater than 50 is " + sumGreater50);
    }
}

