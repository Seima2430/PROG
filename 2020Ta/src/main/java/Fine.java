// This abstract class provides a common structure and some implementation for fines.
public abstract class Fine implements iFine {
    
    // Protected variables so they are accessible to subclasses.
    protected String citizenName;
    protected int speed;
    protected double finePayable;

    // Constructor to initialize the citizen's name and speed.
    public Fine(String citizenName, int speed) {
        this.citizenName = citizenName;
        this.speed = speed;
        this.calculateFine(); // Calculate the fine as soon as we have the speed.
    }

    // Getter methods to access the private variables.
    public String getCitizenName() {
        return citizenName;
    }

    public int getSpeed() {
        return speed;
    }

    public double getFinePayable() {
        return finePayable;
    }

    // Method to calculate the fine amount.
    // The fine is R10.20 per km/h over 120km/h. No fine if under 120km/h.
    public void calculateFine() {
        if (this.speed >= 120) {
            this.finePayable = this.speed * 10.20;
        } else {
            this.finePayable = 0.0;
        }
    }

    // The PrintFine method is declared here because of the interface,
    // but we don't provide an implementation. The subclass must do that.
    public abstract void PrintFine();
}