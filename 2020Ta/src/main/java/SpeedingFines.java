// This concrete class extends the abstract Fine class and provides specific implementation.
public class SpeedingFines extends Fine {

    // Constructor simply calls the constructor of the parent (Fine) class.
    public SpeedingFines(String citizenName, int speed) {
        super(citizenName, speed);
    }

    // Here we provide the actual implementation for printing the fine details.
    @Override
    public void PrintFine() {
        System.out.println("*********************");
        System.out.println("PERSON: " + this.citizenName);
        System.out.println("SPEED: " + this.speed + "km");
        // Format the fine to a whole number as shown in the sample output.
        System.out.println("FINE PAYABLE: R " + (int) this.finePayable);
        System.out.println("*********************");
    }
}