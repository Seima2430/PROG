/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentscoresanalyzer;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class StudentScoresAnalyzer 
{

    public static void main(String[] args) 
    {
        System.out.println(" Student Scores Analyzer ");
        System.out.println("=== Student Scores Analyzer ===");
        Scanner myScan = new Scanner(System.in); 
        
        // Array to store 10 student scores
        int[] scores = new int[10];
        
        // Counters and trackers
        int passed = 0;      // Number of students who passed (score >= 50)
        int failed = 0;      // Number of students who failed (score < 50)
        int total = 0;       // Sum of all scores (used for average calculation)
        int above75 = 0;     // Number of students scoring above 75
        int lowest = Integer.MAX_VALUE; // Track the lowest score

        System.out.println("Enter the scores of 10 students:");

        // Input loop for 10 student scores
        for (int i = 0; i < scores.length; i++)
        {
            System.out.print("Student " + (i + 1) + ": ");
            scores[i] = myScan.nextInt(); 

            // Check if student passed or failed
            if (scores[i] >= 50) 
            {
                passed++;
            }
            else 
            {
                failed++;
            }

            // Count students with scores above 75
            if (scores[i] > 75) 
            {
                above75++;
            }

            // Update the lowest score
            if (scores[i] < lowest) 
            {
                lowest = scores[i];
            }

            // Add score to total for average calculation
            total += scores[i];
        }

        // Calculate average score
        double average = (double) total / scores.length;

        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Number of students who passed: " + passed);
        System.out.println("Number of students who failed: " + failed);
        System.out.println("Average score: " + average);
        System.out.println("Lowest score: " + lowest);
        System.out.println("Number of students who scored above 75: " + above75);
    }
}
