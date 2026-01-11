/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dayofweekfinder;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class DayOfWeekFinder 
{

    public static void main(String[] args) 
    {
        System.out.println("Day Of Week Finder");
        System.out.println("=== Days Of The Week ===");
        Scanner myScan = new Scanner(System.in);
        
        // Step 1: Get user details
        System.out.print("Please enter your name: ");
        String name = myScan.nextLine();
        
        // Step 2: Get numeric input for day of week
        System.out.print("Please enter a number (1–7): ");
        int value = myScan.nextInt();
        
        // Step 3: Map number to day of the week
        if (value == 1)
        {
            System.out.println(name + ", this day is Monday");
        }
        else if (value == 2)
        {
            System.out.println(name + ", this day is Tuesday");
        }
        else if (value == 3)
        {
            System.out.println(name + ", this day is Wednesday");
        }
        else if (value == 4)
        {
            System.out.println(name + ", this day is Thursday");
        }
        else if (value == 5)
        {
            System.out.println(name + ", this day is Friday");
        }
        else if (value == 6)
        {
            System.out.println(name + ", this day is Saturday");
        }
        else if (value == 7)
        {
            System.out.println(name + ", this day is Sunday");
        }
        else 
        {
            // Step 4: Input validation
            System.out.println("Error: please enter a value between 1 and 7");
        }
    }
}
