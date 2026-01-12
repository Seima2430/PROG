import java.util.Arrays;

/**
 * PROG6112 Take-Home Test - Question 1
 * Home Makeover Report Application
 * This program displays a renovator's monthly home makeover jobs
 * and calculates monthly totals with special indicators for high volumes.
 * 
 * @author Student
 * @version 1.0
 */
public class HomeMakeoverReport {
    
    public static void main(String[] args) {
        // Display program header
        System.out.println("HOME MAKEOVER REPORT");
        System.out.println("---");
        
        // Declare and populate two-dimensional array for monthly makeover data
        // Rows represent months, columns represent: Bathrooms, Kitchens, Garden
        int[][] makeoverData = {
            {8, 2, 5},   // January
            {7, 4, 5},   // February
            {5, 5, 2},   // March
            {2, 2, 3},   // April
            {7, 7, 9},   // May
            {7, 8, 5}    // June
        };
        
        // Array to store month names for display purposes
        String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN"};
        
        // Print table header
        System.out.println("    Bathrooms    Kitchens    Garden");
        
        // Display monthly makeover data
        for (int i = 0; i < makeoverData.length; i++) {
            System.out.print(months[i] + "    ");
            for (int j = 0; j < makeoverData[i].length; j++) {
                System.out.print(makeoverData[i][j] + "    ");
            }
            System.out.println(); // Move to next line after each month
        }
        
        System.out.println("---");
        System.out.println("MONTHLY TOTALS");
        System.out.println("---");
        
        // Calculate and display monthly totals
        for (int i = 0; i < makeoverData.length; i++) {
            int monthlyTotal = 0;
            
            // Calculate total makeovers for current month
            for (int j = 0; j < makeoverData[i].length; j++) {
                monthlyTotal += makeoverData[i][j];
            }
            
            // Display month and total
            System.out.print(months[i] + "    " + monthlyTotal + "    ");
            
            // Decision making: Display stars if total is 15 or more
            if (monthlyTotal >= 15) {
                System.out.print("***");
            }
            
            System.out.println(); // New line for next month
        }
    }
}