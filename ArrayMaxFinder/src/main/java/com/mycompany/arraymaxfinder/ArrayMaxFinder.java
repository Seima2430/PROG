/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arraymaxfinder;

/**
 *
 * @author RC_Student_lab
 */
public class ArrayMaxFinder 
{

    public static void main(String[] args) 
    {
        System.out.println("Array Max Finder");
        
        // Step 1: Declare and initialize an array
        int[] numbers = {10, 25, 7, 43, 12};
        
        // Step 2: Print each element in the array
        System.out.println("Array elements are:");
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.println(numbers[i]);
        }
        
        // Step 3: Find the maximum number in the array
        int max = numbers[0]; // Assume first element is the largest
        for (int i = 1; i < numbers.length; i++) 
        {
            if (numbers[i] > max) 
            {
                max = numbers[i]; // Update max if current element is larger
            }
        }
        
        // Step 4: Display the maximum number
        System.out.println("The maximum number is: " + max);
    }
}
    