import java.util.Scanner;

/**
 * PROG6112 Test - Question 1
 * Road Accident Analysis Application
 * This program records and displays road accidents for cars and motorbikes
 * across three different South African cities.
 * 
 * Student: [Your Student Number]
 * Module: PROG6112
 */
public class RoadAccidentAnalysis {
    
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Define city names array
        String[] cities = {"Cape Town", "Johannesburg", "Port Elizabeth"};
        
        // Define vehicle types array
        String[] vehicleTypes = {"Car", "Motor Bike"};
        
        // Create 2D array to store accident data: [city][vehicle type]
        // 3 cities x 2 vehicle types
        int[][] accidentData = new int[3][2];
        
        // Create array to store total accidents per city
        int[] cityTotals = new int[3];
        
        System.out.println("ROAD ACCIDENT DATA ENTRY");
        System.out.println("========================");
        
        // Populate the 2D array with user input
        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < vehicleTypes.length; j++) {
                System.out.print("Enter the number of " + vehicleTypes[j].toLowerCase() + 
                               " accidents for " + cities[i] + ": ");
                accidentData[i][j] = scanner.nextInt();
            }
            System.out.println(); // Add blank line for better readability
        }
        
        // Calculate total accidents for each city
        for (int i = 0; i < cities.length; i++) {
            cityTotals[i] = accidentData[i][0] + accidentData[i][1];
        }
        
        // Find city with most accidents
        int maxAccidents = cityTotals[0];
        String cityWithMostAccidents = cities[0];
        
        for (int i = 1; i < cities.length; i++) {
            if (cityTotals[i] > maxAccidents) {
                maxAccidents = cityTotals[i];
                cityWithMostAccidents = cities[i];
            }
        }
        
        // Display the Road Accident Report
        displayAccidentReport(cities, vehicleTypes, accidentData, cityTotals, cityWithMostAccidents);
        
        scanner.close();
    }
    
    /**
     * Displays a comprehensive road accident report
     * @param cities Array of city names
     * @param vehicleTypes Array of vehicle types
     * @param accidentData 2D array containing accident counts
     * @param cityTotals Array containing total accidents per city
     * @param cityWithMostAccidents City having the highest accident count
     */
    public static void displayAccidentReport(String[] cities, String[] vehicleTypes, 
                                           int[][] accidentData, int[] cityTotals, 
                                           String cityWithMostAccidents) {
        
        System.out.println("ROAD ACCIDENT REPORT");
        System.out.println("---");
        
        // Display detailed accident data for each city
        for (int i = 0; i < cities.length; i++) {
            System.out.printf("%-15s %s %d %s %d%n", 
                            cities[i], 
                            vehicleTypes[0].toUpperCase(), 
                            accidentData[i][0], 
                            vehicleTypes[1].toUpperCase(), 
                            accidentData[i][1]);
        }
        
        System.out.println("\nROAD ACCIDENT TOTALS FOR EACH CITY");
        System.out.println("---");
        
        // Display total accidents per city
        for (int i = 0; i < cities.length; i++) {
            System.out.printf("%-15s %d%n", cities[i], cityTotals[i]);
        }
        
        // Display city with most accidents
        System.out.println("\nCITY WITH THE MOST VEHICLE ACCIDENTS: " + cityWithMostAccidents);
        System.out.println("---");
    }
}