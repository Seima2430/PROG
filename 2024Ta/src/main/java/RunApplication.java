import java.util.Scanner;

/**
 * PROG6112 Test - Question 2
 * Object-Oriented Road Accident Reporting System
 * This program demonstrates inheritance, abstraction, and interface implementation
 * for managing road accident reports.
 * 
 * Student: [Your Student Number]
 * Module: PROG6112
 */

// Interface defining contract for road accident data
interface iRoadAccidents {
    String getAccidentVehicleType();
    String getCity();
    int getAccidentTotal();
}

// Abstract class implementing the interface
abstract class RoadAccidents implements iRoadAccidents {
    // Protected instance variables for data encapsulation
    protected String vehicleType;
    protected String city;
    protected int accidentCount;
    
    /**
     * Constructor for RoadAccidents class
     * @param vehicleType Type of vehicle involved in accidents
     * @param city City where accidents occurred
     * @param accidentCount Total number of accidents
     */
    public RoadAccidents(String vehicleType, String city, int accidentCount) {
        this.vehicleType = vehicleType;
        this.city = city;
        this.accidentCount = accidentCount;
    }
    
    // Interface method implementations
    @Override
    public String getAccidentVehicleType() {
        return vehicleType;
    }
    
    @Override
    public String getCity() {
        return city;
    }
    
    @Override
    public int getAccidentTotal() {
        return accidentCount;
    }
}

// Concrete subclass for generating accident reports
class RoadAccidentReport extends RoadAccidents {
    
    /**
     * Constructor for RoadAccidentReport class
     * @param vehicleType Type of vehicle involved in accidents
     * @param city City where accidents occurred
     * @param accidentCount Total number of accidents
     */
    public RoadAccidentReport(String vehicleType, String city, int accidentCount) {
        // Call parent class constructor
        super(vehicleType, city, accidentCount);
    }
    
    /**
     * Prints a formatted accident report
     */
    public void printAccidentReport() {
        System.out.println("\nVEHICLE ACCIDENT REPORT");
        System.out.println("***************");
        System.out.println("VEHICLE TYPE: " + getAccidentVehicleType());
        System.out.println("CITY: " + getCity());
        System.out.println("ACCIDENT TOTAL: " + getAccidentTotal());
        System.out.println("***************");
    }
}

// Main application class to run the program
public class RunApplication {
    
    public static void main(String[] args) {
        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("VEHICLE ACCIDENT REPORTING SYSTEM");
        System.out.println("==================================");
        
        // Collect user input for accident data
        System.out.print("Enter the accident vehicle type: ");
        String vehicleType = scanner.nextLine();
        
        System.out.print("Enter the city for the vehicle accidents: ");
        String city = scanner.nextLine();
        
        System.out.print("Enter the total " + vehicleType + " accidents for " + city + ": ");
        int accidentCount = scanner.nextInt();
        
        // Create RoadAccidentReport object with user input
        RoadAccidentReport report = new RoadAccidentReport(vehicleType, city, accidentCount);
        
        // Generate and display the accident report
        report.printAccidentReport();
        
        scanner.close();
        
        System.out.println("\nReport generation completed successfully!");
    }
}