import java.util.Scanner;

// This class contains the main method to run the application.
public class SpeedingFineApplication {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user.
        Scanner scanner = new Scanner(System.in);

        // Prompt for and capture the citizen's name.
        System.out.print("Enter the person name: ");
        String name = scanner.nextLine();

        // Prompt for and capture the recorded speed.
        System.out.print("Enter the speed: ");
        int speed = scanner.nextInt();

        // Close the scanner to prevent resource leaks.
        scanner.close();

        // Create a SpeedingFines object with the user's input.
        SpeedingFines fine = new SpeedingFines(name, speed);

        // Call the PrintFine method to display the result.
        fine.PrintFine();
    }
}
