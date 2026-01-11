// File: MovieTicketsGUI.java
/**
 * This class contains the business logic for calculating prices and validating data for the GUI application.
 */
public class MovieTicketsGUI implements IMovieTickets {

    // VAT rate as a constant (14%)
    private static final double VAT_RATE = 0.14;

    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        // Calculate subtotal, then add VAT
        double subTotal = numberOfTickets * ticketPrice;
        double vatAmount = subTotal * VAT_RATE;
        double totalPrice = subTotal + vatAmount;
        return totalPrice;
    }

    @Override
    public boolean ValidateData(MovieTicketData movieTicketData) {
        // Check all validation rules (Q2.7)
        if (movieTicketData.movieName == null || movieTicketData.movieName.trim().isEmpty()) {
            return false; // Movie name cannot be empty
        }
        if (movieTicketData.numberOfTickets <= 0) {
            return false; // Number of tickets must be positive
        }
        if (movieTicketData.ticketPrice <= 0) {
            return false; // Ticket price must be positive
        }
        return true; // All validation rules passed
    }
}
