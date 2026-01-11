
import javax.xml.crypto.Data;

/**
 * Interface for the GUI application's Estate Agent functions.
 */
public interface IEstateAgent {
    
    /**
     * Calculates the commission from string inputs.
     * @param propertyPrice The property price as a string.
     * @param agentCommission The commission percentage as a string.
     * @return The calculated commission amount.
     */
    double CalculateCommission(String propertyPrice, String agentCommission);
    
    /**
     * Validates all input data.
     * @param dataToValidate The Data object containing all user inputs.
     * @return true if all data is valid, false otherwise.
     */
    boolean ValidateData(Data dataToValidate);
}