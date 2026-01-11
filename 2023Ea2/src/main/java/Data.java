/**
 * A simple data class to hold all the input from the GUI form.
 * This makes it easy to pass all data around as a single object.
 */
public class Data {
    public String agentLocation;
    public String agentName;
    public String propertyPrice;
    public String commissionPercentage;

    public Data(String location, String name, String price, String commission) {
        this.agentLocation = location;
        this.agentName = name;
        this.propertyPrice = price;
        this.commissionPercentage = commission;
    }
}
