// Import for formatting numbers with commas
import java.text.NumberFormat;

public class PropertyPriceAnalyzer {

    public static void main(String[] args) {
        // Create a number formatter for South African Rand style
        NumberFormat currencyFormat = NumberFormat.getNumberInstance();
        currencyFormat.setGroupingUsed(true); // This will add commas (e.g., 1,433,333)

        // Q.2.1: Declare and populate the 2D array with property prices
        // Rows: Provinces, Columns: Property Types (Flat, Townhouse, House)
        int[][] propertyPrices = {
                {800000, 1500000, 2000000}, // Gauteng
                {700000, 1200000, 1600000}, // Natal
                {750000, 1300000, 1800000}  // Cape
        };

        // Q.2.1: Single array to store province names
        String[] provinces = {"Gauteng", "Natal", "Cape"};

        // Print the table header
        System.out.println("FLAT\t\tTOWNHOUSE\tHOUSE");
        System.out.println("----------------------------------------");

        // Print the property prices for each province
        for (int i = 0; i < propertyPrices.length; i++) {
            System.out.print(provinces[i] + "\t");
            for (int j = 0; j < propertyPrices[i].length; j++) {
                System.out.print("R " + propertyPrices[i][j] + "\t");
            }
            System.out.println(); // Move to the next line after each province
        }

        System.out.println("\n--- Average Property Prices ---");

        // Q.2.2: Calculate and print the total average property price for each province
        for (int i = 0; i < propertyPrices.length; i++) {
            int sum = 0;
            // Sum all property prices for the current province
            for (int price : propertyPrices[i]) {
                sum += price;
            }
            // Calculate the average. Using double for accurate division.
            double average = (double) sum / propertyPrices[i].length;

            // Format the average and print the result
            String formattedAverage = currencyFormat.format(average);
            System.out.println("Average property prices in " + provinces[i] + " = R " + formattedAverage);
        }
    }
}
