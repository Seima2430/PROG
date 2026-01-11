/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arrayiterationdemo;

/**
 *
 * @author RC_Student_lab
 */
public class ArrayIterationDemo 
{

    public static void main(String[] args)
    {
        System.out.println("Array Iteration Demo");
        
        // Step 1: Declare and initialize an integer array
        int[] numbers = {10, 20, 30, 40, 50};
        
        // Step 2: Use a loop to print each integer element
        System.out.println("Integer array elements are:");
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.println(numbers[i]);
        }
        
        // Step 3: Declare and initialize a string array
        String[] colleges = {"Varsity College", "Vega College", "Rosebank College"};
         
        // Step 4: Use a loop to print each string element
        System.out.println("\nString array elements are:");
        for (int z = 0; z < colleges.length; z++)
        {
            System.out.println(colleges[z]);
        }
    }
}
