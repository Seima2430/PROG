// File: MovieReportApp.java
/**
 * This application generates a sales report for two movies over three months.
 * It demonstrates the use of single and two-dimensional arrays.
 */
public class MovieReportApp {

    public static void main(String[] args) {
        // Declare and populate the arrays with the given data
        String[] movieNames = {"Napoleon", "Oppenheimer"};
        int[][] monthlySales = {
            {3000, 1500, 1700}, // Napoleon's sales for Jan, Feb, Mar
            {3500, 1200, 1600}  // Oppenheimer's sales for Jan, Feb, Mar
        };

        // Create an instance of the MovieTickets class to use its methods
        MovieTickets ticketProcessor = new MovieTickets();

        // Arrays to store the calculated total sales for each movie
        int[] totalSalesPerMovie = new int[movieNames.length];

        // --- Generate the Report Header ---
        System.out.println("MOVIE TICKET SALES REPORT – 2024\n");
        System.out.printf("%-12s %-6s %-6s %-6s%n", "", "JAN", "FEB", "MAR");

        // --- Print the Sales Data and Calculate Totals ---
        for (int i = 0; i < movieNames.length; i++) {
            // Print each movie's name and its monthly sales
            System.out.printf("%-12s %-6d %-6d %-6d%n",
                    movieNames[i],
                    monthlySales[i][0],
                    monthlySales[i][1],
                    monthlySales[i][2]);

            // Calculate the total sales for the current movie
            totalSalesPerMovie[i] = ticketProcessor.TotalMovieSales(monthlySales[i]);
        }

        System.out.println(); // Print a blank line for readability

        // --- Print Total Sales for Each Movie ---
        for (int i = 0; i < movieNames.length; i++) {
            // Note: The sample uses '€', but the instruction says "total movie ticket sales", so we'll just print the number.
            // If currency is required, you could format it.
            System.out.println("Total movie ticket sales for " + movieNames[i] + ": " + totalSalesPerMovie[i]);
        }

        // --- Determine and Print the Top Movie ---
        String topMovie = ticketProcessor.TopMovie(movieNames, totalSalesPerMovie);
        System.out.println("\nTop performing movie: " + topMovie);
    }
}
