// File: MovieTicketsTest.java
// This file should be in a 'test' package (e.g., right-click src/test/java and create it)

import org.junit.Test;

/**
 * Unit tests for the MovieTickets class.
 */
class MovieTicketsTest {

    // Create an instance of the class we are testing
    private final MovieTickets ticketProcessor = new MovieTickets();

    @Test
    void CalculateTotalSales_ReturnsExpectedTotalSales() {
        // Arrange: Set up the test data
        int[] testSales = {100, 200, 50}; // Total should be 350

        // Act: Call the method we are testing
        int actualTotal = ticketProcessor.TotalMovieSales(testSales);

        // Assert: Check if the result is as expected
        assertEquals(350, actualTotal, "The total sales calculation is incorrect.");
    }

    @Test
    void TopMovieSales_ReturnsTopMovie() {
        // Arrange
        String[] movies = {"MovieA", "MovieB", "MovieC"};
        int[] sales = {500, 750, 600}; // MovieB should be the top

        // Act
        String topMovie = ticketProcessor.TopMovie(movies, sales);

        // Assert
        assertEquals("MovieB", topMovie, "The top movie was not correctly identified.");
    }

    // Optional: Test for edge cases, like an empty array.
    @Test
    void TopMovie_WithInvalidData_ReturnsMessage() {
        // Arrange
        String[] movies = {};
        int[] sales = {};

        // Act
        String result = ticketProcessor.TopMovie(movies, sales);

        // Assert
        assertEquals("Invalid data provided.", result, "The method should handle empty arrays gracefully.");
    }

    private void assertEquals(int i, int actualTotal, String the_total_sales_calculation_is_incorrect) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(String movieB, String topMovie, String the_top_movie_was_not_correctly_identifie) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
