// File: MovieTicketData.java
/**
 * A simple class to hold the data for a movie ticket purchase.
 * This makes it easier to pass data around for validation.
 */
public class MovieTicketData {
    public String movieName;
    public int numberOfTickets;
    public double ticketPrice;

    public MovieTicketData(String movieName, int numberOfTickets, double ticketPrice) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
    }
}
