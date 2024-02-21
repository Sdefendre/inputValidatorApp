import java.util.Scanner;
import java.util.InputMismatchException;

public class ValidatorNumeric {
    private String prompt;
    private double min;
    private double max;

    public ValidatorNumeric(String prompt, double min, double max) {
        this.prompt = prompt;
        this.min = min;
        this.max = max;
    }

    // Consolidated method to get either double or int within range
    public double getNumberWithinRange(Scanner scanner) {
        double input = 0;
        do {
            System.out.print(prompt);
            try {
                input = scanner.nextDouble(); // Attempt to read as double
                if (input < min || input > max) {
                    System.out.println("Error! Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error! Invalid numeric value. Try again.");
                scanner.next(); // Clear invalid input
            }
        } while (input < min || input > max);

        return input;
    }

    public int getIntWithinRange(Scanner scanner) {
        int input = 0;
        do {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                if (input < min || input > max) {
                    System.out.println("Error! Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error! Invalid numeric value. Try again.");
                scanner.next(); // Clear invalid input
            }
        } while (input < min || input > max);
        
        return input;
    }
}