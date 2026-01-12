import java.util.Scanner;

// Interface defining the contract for all recipe classes
interface iRecipes {
    // Any class that implements this interface must provide this method
    public void PrintRecipes();
}

// Abstract class that provides a blueprint for a recipe
// It implements the iRecipes interface, so it promises to have a PrintRecipes method.
abstract class Recipes implements iRecipes {
    // Protected variables so they are accessible in subclasses
    protected String ingredients;
    protected int timeToMake; // in minutes
    protected int difficultyLevel; // e.g., on a scale of 1 to 5

    // Constructor to initialize a Recipe object with its essential properties
    public Recipes(String ingredients, int timeToMake, int difficultyLevel) {
        this.ingredients = ingredients;
        this.timeToMake = timeToMake;
        this.difficultyLevel = difficultyLevel;
    }

    // Getter methods to allow access to the private variables from outside the class
    public String getIngredients() {
        return ingredients;
    }

    public int getTimeToMake() {
        return timeToMake;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }
}

// Concrete class that provides the actual implementation for the abstract Recipes class
class ProcessRecipe extends Recipes {

    // Constructor that simply passes the received parameters to the parent (Recipes) constructor
    public ProcessRecipe(String ingredients, int timeToMake, int difficultyLevel) {
        super(ingredients, timeToMake, difficultyLevel); // Call the parent constructor
    }

    // Implementation of the PrintRecipes method from the iRecipes interface
    @Override
    public void PrintRecipes() {
        // Print the recipe details in a formatted way
        System.out.println("**********************************************");
        System.out.println("INGREDIENTS: " + this.getIngredients());
        System.out.println("TIME TO MAKE: " + this.getTimeToMake() + " minutes");
        System.out.println("DIFFICULTY LEVEL: " + this.getDifficultyLevel() + "/5");
        System.out.println("**********************************************");
    }
}

// Main application class that handles user interaction
public class BakingApplication {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the recipe details
        System.out.print("Enter the ingredients: ");
        String ingredients = scanner.nextLine(); // Read the whole line of ingredients

        System.out.print("Enter time to make (in minutes): ");
        int time = scanner.nextInt(); // Read the time as an integer

        System.out.print("Enter difficulty level: ");
        int difficulty = scanner.nextInt(); // Read the difficulty as an integer

        // Close the scanner to prevent resource leaks
        scanner.close();

        // Create an instance of ProcessRecipe with the user-provided data
        ProcessRecipe myRecipe = new ProcessRecipe(ingredients, time, difficulty);

        // Call the method to print the recipe details
        myRecipe.PrintRecipes();
    }
}
