import java.util.Scanner;

/**
 * PROG6112 Take-Home Test - Question 2
 * Staff Hiring Recommendation System
 * This application determines if a company should hire more staff
 * based on current staff levels and location.
 * 
 * @author Student
 * @version 1.0
 */

// Interface defining staff-related operations
interface iStaff {
    public int getStaffNumber();
    public String getStaffLocation();
    public String getStaffHiringProcess();
}

// Abstract class implementing the iStaff interface
abstract class Staff implements iStaff {
    // Protected variables to store staff information
    protected int staffNumber;
    protected String staffLocation;
    
    // Constructor to initialize staff data
    public Staff(int staffNumber, String staffLocation) {
        this.staffNumber = staffNumber;
        this.staffLocation = staffLocation;
    }
    
    // Implementation of interface methods
    @Override
    public int getStaffNumber() {
        return staffNumber;
    }
    
    @Override
    public String getStaffLocation() {
        return staffLocation;
    }
    
    // Abstract method to be implemented by subclass
    @Override
    public abstract String getStaffHiringProcess();
}

// Subclass that extends the abstract Staff class
class StaffHiring extends Staff {
    
    // Constructor that calls parent class constructor
    public StaffHiring(int staffNumber, String staffLocation) {
        super(staffNumber, staffLocation);
    }
    
    // Implementation of the abstract method
    @Override
    public String getStaffHiringProcess() {
        // Decision logic: Hire staff if less than 20 members
        if (staffNumber < 20) {
            return "YES";
        } else {
            return "NO";
        }
    }
    
    // Method to display staff hiring report
    public void printStaffHiring() {
        System.out.println("\nSTAFF HIRING REPORT");
        System.out.println("***************");
        System.out.println("LOCATION: " + getStaffLocation());
        System.out.println("STAFF NUMBER: " + getStaffNumber());
        System.out.println("HIRE STAFF: " + getStaffHiringProcess());
    }
}

// Main class to test the staff hiring system
public class UseStaff {
    public static void main(String[] args) {
        // Create scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Get staff number from user
        System.out.print("Enter the current staff number: ");
        int staffNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        // Get staff location from user
        System.out.print("Enter the staff hiring location: ");
        String staffLocation = scanner.nextLine();
        
        // Create StaffHiring object with user input
        StaffHiring staffHiring = new StaffHiring(staffNumber, staffLocation);
        
        // Display the hiring report
        staffHiring.printStaffHiring();
        
        // Close scanner to prevent resource leak
        scanner.close();
    }
}
