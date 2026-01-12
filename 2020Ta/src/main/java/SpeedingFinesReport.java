import java.util.Arrays;

public class SpeedingFinesReport {

    public static void main(String[] args) {
        
        // Declare and populate the 2D array with the provided speeding fines data.
        // Rows represent cities, columns represent months.
        int[][] speedingFines = {
            {128, 135, 139}, // JHB
            {155, 129, 175}, // DBN
            {129, 130, 185}, // CTN
            {195, 155, 221}  // PE
        };

        // Array of city names for display purposes.
        String[] cities = {"JHB", "DBN", "CTN", "PE"};
        // Array of month abbreviations for the header.
        String[] months = {"JAN", "FEB", "MAR"};

        // Print the report header.
        System.out.println("*******************************");
        System.out.println("SPEEDING FINES REPORT");
        System.out.println("*******************************");

        // Print the column headers (months).
        System.out.print("    "); // Initial spacing for the city column
        for (String month : months) {
            System.out.print(month + "    ");
        }
        System.out.println(); // Move to the next line after printing headers.

        // Print each city's row of data.
        for (int i = 0; i < speedingFines.length; i++) {
            System.out.print(cities[i] + "   "); // Print the city name.
            for (int j = 0; j < speedingFines[i].length; j++) {
                // Print each fine, formatted to align with headers.
                System.out.print(speedingFines[i][j] + "km    ");
            }
            System.out.println(); // Move to the next line after each city.
        }

        // Find the maximum and minimum speeding fines in the 2D array.
        // Initialize with the first element of the array.
        int maxFine = speedingFines[0][0];
        int minFine = speedingFines[0][0];

        // Loop through every element in the 2D array.
        for (int[] cityFines : speedingFines) {
            for (int fine : cityFines) {
                if (fine > maxFine) {
                    maxFine = fine; // Update maxFine if a higher value is found.
                }
                if (fine < minFine) {
                    minFine = fine; // Update minFine if a lower value is found.
                }
            }
        }

        // Print the statistics section.
        System.out.println("\nSPEEDING FINES STATISTICS");
        System.out.println("*******************************");
        System.out.println("Maximum speed captured: " + maxFine + "km");
        System.out.println("Minimum speed captured: " + minFine + "km");
        System.out.println("*******************************");
    }
}
