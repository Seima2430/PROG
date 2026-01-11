/**
 * This class implements the IEstateAgent interface and provides
 * the concrete logic for sales and commission calculations.
 */
public class EstateAgent implements IEstateAgent {

    @Override
    public double EstateAgentSales(double[] propertySales) {
        double total = 0;
        // Loop through each month's sales and accumulate the total
        for (double sale : propertySales) {
            total += sale;
        }
        return total;
    }

    @Override
    public double EstateAgentCommission(double propertySales) {
        // Commission is 2% of the total sales
        final double COMMISSION_RATE = 0.02;
        return propertySales * COMMISSION_RATE;
    }

    @Override
    public int TopEstateAgent(double[] totalSales) {
        int topAgentIndex = 0;
        double maxSales = totalSales[0];
        
        // Loop through sales figures to find the highest one
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > maxSales) {
                maxSales = totalSales[i];
                topAgentIndex = i;
            }
        }
        return topAgentIndex;
    }
}
