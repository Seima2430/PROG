// File: IMovieTickets.java
/**
 * Interface for GUI-related movie ticket operations.
 */
public interface IMovieTickets {
    double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice);
    boolean ValidateData(MovieTicketData movieTicketData);
}
