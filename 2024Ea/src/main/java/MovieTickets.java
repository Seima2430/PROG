// File: MovieTickets.java
/**
 * This class provides implementations for calculating movie ticket sales
 * and determining the top-performing movie.
 */
public class MovieTickets implements iMovieTickets {

    @Override
    public int TotalMovieSales(int[] movieTicketSales) {
        int total = 0;
        // Loop through each month's sales and add them to the total
        for (int sales : movieTicketSales) {
            total += sales;
        }
        return total;
    }

    @Override
    public String TopMovie(String[] movies, int[] totalSales) {
        // Input validation is always a good practice
        if (movies == null || totalSales == null || movies.length != totalSales.length || movies.length == 0) {
            return "Invalid data provided.";
        }

        // Assume the first movie is the top initially
        String topMovie = movies[0];
        int maxSales = totalSales[0];

        // Loop through the rest to find the actual top movie
        for (int i = 1; i < movies.length; i++) {
            if (totalSales[i] > maxSales) {
                maxSales = totalSales[i];
                topMovie = movies[i];
            }
        }
        return topMovie;
    }
}