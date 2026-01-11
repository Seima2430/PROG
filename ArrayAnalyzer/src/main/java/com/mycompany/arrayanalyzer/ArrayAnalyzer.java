/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arrayanalyzer;

/**
 *
 * @author RC_Student_lab
 */
public class ArrayAnalyzer 
{

    public static void main(String[] args) 
    {
        System.out.println(" Array Analyzer");
        System.out.println("=== Array Analyzer ===");
        System.out.print("Array elements: ");
        
        // Define an array of integers with at least 5 elements
        int[] numbers = {12, 45, 7, 89, 23}; 
        
        // Display the array elements
        displayArray(numbers);

        // Calculate and display the sum of elements
        int sum = calculateSum(numbers);
        System.out.println("Sum of elements: " + sum);

        // Find and display the maximum value
        int max = findMax(numbers);
        System.out.println("Maximum value: " + max);

        // Calculate and display the average
        double average = calculateAverage(numbers);
        System.out.println("Average value: " + average);
    }

    /**
     * Displays the elements of the array.
     */
    public static void displayArray(int[] array) 
    {
        for (int num : array) 
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * Calculates the sum of array elements.
     * @param array input array
     * @return sum of elements
     */
    public static int calculateSum(int[] array) 
    {
        int sum = 0;
        for (int num : array) 
        {
            sum += num;
        }
        return sum;
    }

    /**
     * Finds the maximum value in the array.
     * @param array input array
     * @return maximum value
     */
    public static int findMax(int[] array) 
    {
        int max = array[0]; // assume first element is the max initially
        for (int num : array) 
        {
            if (num > max) 
            {
                max = num;
            }
        }
        return max;
    }

    /**
     * Calculates the average of array elements.
     * @param array input array
     * @return average value
     */
    public static double calculateAverage(int[] array)
    {
        int sum = calculateSum(array); // reuse the sum method
        return (double) sum / array.length;
    }
   
}
