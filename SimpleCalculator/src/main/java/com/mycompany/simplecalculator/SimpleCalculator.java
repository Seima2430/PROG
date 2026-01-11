/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.simplecalculator;

/**
 *
 * @author RC_Student_lab
 */
public class SimpleCalculator 
{    // Global variables
    static int num1 = 10;
    static int num2 = 4;
    static int results;  
    
    public static void main(String[] args) 
    {
        System.out.println("=== Simple Calculator ===");
        
        // Step 1: Call methods to perform calculations
        add(num1, num2);
        subtract(num1, num2);
    }
    
    /**
     * Method to add two numbers and display the result
     * @param firstValue first number
     * @param secondValue second number
     */
    public static void add(int firstValue, int secondValue)
    {
        results = firstValue + secondValue;
        System.out.println("Addition Result: " + results);
    }
    
    /**
     * Method to subtract the second number from the first and display the result
     * @param firstValue first number
     * @param secondValue second number
     */
    public static void subtract(int firstValue, int secondValue)
    {
        results = firstValue - secondValue;
        System.out.println("Subtraction Result: " + results); 
    }
}
