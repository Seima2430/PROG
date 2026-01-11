// File: iMovieTickets.java
/**
 * Interface defining the contract for movie ticket operations.
 */
public interface iMovieTickets {
    /**
     * Calculates the total sales from an array of monthly sales.
     * @param movieTicketSales an array of sales figures for each month.
     * @return the sum of all sales in the array.
     */
    int TotalMovieSales(int[] movieTicketSales);

    /**
     * Determines the movie with the highest total sales.
     * @param movies an array of movie names.
     * @param totalSales an array of total sales corresponding to each movie.
     * @return the name of the top-performing movie.
     */
    String TopMovie(String[] movies, int[] totalSales);
}