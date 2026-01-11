/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.votingeligibilitychecker;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class VotingEligibilityChecker 
{

    public static void main(String[] args) 
    {
        System.out.println("Voting Eligibility Checker");
        
        System.out.println("=== Voting Eligibility Checker ===");
        Scanner myScan = new Scanner(System.in);
        
        // Step 1: Get age from the user
        System.out.print("Please enter your age: ");
        int age = myScan.nextInt();
        
        // Step 2: Check for invalid age
        if (age < 1)
        {
            System.out.println("Error: Please enter a valid age.");
        }
        // Step 3: Check for voting eligibility
        else if (age < 18)
        {
            System.out.println("You cannot vote yet. Please wait until you are 18.");
        }
        else if (age <= 65)
        {
            System.out.println("You are allowed to vote.");
        }
        else
        {
            System.out.println("Special voting privileges granted.");
        }
    }
}
