/**
 * Interface defining the contract for Estate Agent calculations.
 * This ensures that any implementing class will have these specific methods.
 */
public interface IEstateAgent {
    
    /**
     * Calculates the total sales from an array of monthly property sales.
     * @param propertySales An array of sales figures for each month.
     * @return The total sales value.
     */
    double EstateAgentSales(double[] propertySales);
    
    /**
     * Calculates the commission earned based on total property sales.
     * The commission rate is fixed at 2%.
     * @param propertySales The total sales figure.
     * @return The calculated commission.
     */
    double EstateAgentCommission(double propertySales);
    
    /**
     * Determines the index of the top-performing estate agent.
     * @param totalSales An array of total sales for each agent.
     * @return The index of the agent with the highest sales.
     */
    int TopEstateAgent(double[] totalSales);
}