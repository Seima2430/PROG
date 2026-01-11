/**
 * The main application class for Question 1.
 * It uses a 2D array to store sales data and generates a sales report.
 */
public class EstateAgentSales {

    public static void main(String[] args) {
        // Define the 2D array with the provided sales data
        // Rows: Estate Agents, Columns: Months (Jan, Feb, Mar)
        double[][] propertySales = {
            {800000, 1500000, 2000000}, // Joe Bloggs
            {700000, 1200000, 1600000}  // Jane Doe
        };
        
        String[] agentNames = {"Joe Bloggs", "Jane Doe"};
        String[] months = {"JAN", "FEB", "MAR"};
        
        // Instantiate the EstateAgent class to use its methods
        EstateAgent agentProcessor = new EstateAgent();
        
        // Arrays to store the calculated totals for each agent
        double[] totalSalesPerAgent = new double[agentNames.length];
        double[] totalCommissionPerAgent = new double[agentNames.length];
        
        // Print the report header
        System.out.println("ESTATE AGENTS SALES REPORT\n");
        System.out.printf("%-15s", "");
        for (String month : months) {
            System.out.printf("%-15s", month);
        }
        System.out.println();
        
        // Display the monthly sales for each agent
        for (int i = 0; i < agentNames.length; i++) {
            System.out.printf("%-15s", agentNames[i]);
            for (int j = 0; j < months.length; j++) {
                System.out.printf("R %-12.1f", propertySales[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        
        // Calculate and display total sales and commission for each agent
        for (int i = 0; i < agentNames.length; i++) {
            totalSalesPerAgent[i] = agentProcessor.EstateAgentSales(propertySales[i]);
            totalCommissionPerAgent[i] = agentProcessor.EstateAgentCommission(totalSalesPerAgent[i]);
            
            System.out.printf("Total property sales for %s = R %,.0f%n", agentNames[i], totalSalesPerAgent[i]);
            System.out.printf("Sales Commission for %s = R %,.0f%n", agentNames[i], totalCommissionPerAgent[i]);
            System.out.println();
        }
        
        // Determine and display the top-performing estate agent
        int topAgentIndex = agentProcessor.TopEstateAgent(totalSalesPerAgent);
        System.out.println("Top performing estate agent: " + agentNames[topAgentIndex]);
    }
}
