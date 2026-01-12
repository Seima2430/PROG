import java.util.*;

public class DeliveriesReport {

    public static void main(String[] args) {
        // This is the main method where the program starts execution.

        // Declare and initialize a 2D array with the delivery data for 2018, 2019, and 2020.
        // Rows represent years, columns represent months (Jan, Feb, Mar).
        int[][] deliveries = {
            {128, 135, 139}, // Deliveries for 2018
            {155, 129, 175}, // Deliveries for 2019
            {129, 130, 185}  // Deliveries for 2020
        };

        // Array of year labels for printing the report
        String[] years = {"DELIVERIES 2018", "DELIVERIES 2019", "DELIVERIES 2020"};
        // Array of month headers for printing the report
        String[] months = {"JAN", "FEB", "MAR"};

        // Variables to calculate statistics
        int totalDeliveries = 0;
        int maxDeliveries = deliveries[0][0]; // Start by assuming the first value is the max
        int minDeliveries = deliveries[0][0]; // Start by assuming the first value is the min

        // Print the report header
        System.out.println("*******************************");
        System.out.println("DELIVERIES REPORT");
        System.out.println("*******************************");

        // Print the column headers (months)
        System.out.print("    "); // Initial spacing for row header alignment
        for (String month : months) {
            System.out.print(month + "    ");
        }
        System.out.println(); // Move to the next line after printing headers

        // Loop through the 2D array to print the data and calculate statistics
        for (int i = 0; i < deliveries.length; i++) {
            // Print the year label for the current row
            System.out.print(years[i] + "    ");
            for (int j = 0; j < deliveries[i].length; j++) {
                // Print the delivery figure for the specific month
                System.out.print(deliveries[i][j] + "      ");

                // Add the current value to the running total
                totalDeliveries += deliveries[i][j];

                // Check if the current value is greater than the current maximum
                if (deliveries[i][j] > maxDeliveries) {
                    maxDeliveries = deliveries[i][j];
                }

                // Check if the current value is less than the current minimum
                if (deliveries[i][j] < minDeliveries) {
                    minDeliveries = deliveries[i][j];
                }
            }
            System.out.println(); // Move to the next line after printing each year's data
        }

        // Print the statistics footer
        System.out.println("*******************************");
        System.out.println("DELIVERIES STATISTICS");
        System.out.println("*******************************");
        System.out.println("Total Deliveries:    " + totalDeliveries);
        System.out.println("Maximum Deliveries:  " + maxDeliveries);
        System.out.println("Minimum Deliveries:  " + minDeliveries);
        System.out.println("*******************************");
    }
}
