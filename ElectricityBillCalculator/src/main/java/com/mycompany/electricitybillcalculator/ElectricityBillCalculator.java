/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.electricitybillcalculator;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class ElectricityBillCalculator 
{

    public static void main(String[] args) 
    {
        System.out.println("Electricity Bill Calculator");
        System.out.println("=== Electricity Bill Calculator ===");
        Scanner myScan = new Scanner(System.in); 
        
        // Input: number of electricity units consumed
        System.out.print("Enter the number of electricity units consumed: ");
        double unitsConsumed = myScan.nextDouble(); 
        
        // Input: type of connection (1 = Domestic, 2 = Commercial)
        System.out.print("Enter the type of connection (1 for Domestic, 2 for Commercial): ");
        int connectionType = myScan.nextInt(); 
        
        double totalBill = 0.0;
        String connectionMessage = "";

        // Check for Domestic connection billing
        if (connectionType == 1) 
        {
            connectionMessage = "Domestic";
            
            if (unitsConsumed <= 100) 
            {
                totalBill = unitsConsumed * 3;
            } 
            else if (unitsConsumed <= 200)
            {
                totalBill = (100 * 3) + ((unitsConsumed - 100) * 4);
            } 
            else 
            {
                totalBill = (100 * 3) + (100 * 4) + ((unitsConsumed - 200) * 5);
            }
        } 
        // Check for Commercial connection billing
        else if (connectionType == 2) 
        {
            connectionMessage = "Commercial";
            
            if (unitsConsumed <= 100)
            {
                totalBill = unitsConsumed * 5;
            } 
            else if (unitsConsumed <= 200) 
            {
                totalBill = (100 * 5) + ((unitsConsumed - 100) * 6);
            } 
            else 
            {
                totalBill = (100 * 5) + (100 * 6) + ((unitsConsumed - 200) * 8);
            }
        } 
        // Invalid input case
        else 
        {
            System.out.println("Error: Invalid connection type entered.");
            return;
        }

        // Final output of results
        System.out.println("\n--- Electricity Bill Details ---");
        System.out.println("Connection Type: " + connectionMessage);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Total Bill: R" + totalBill);
    
    }
}
