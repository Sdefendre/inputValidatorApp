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

    public double getNumberWithinRange(Scanner scanner) {
        double input;
        do {
            System.out.print(prompt);
            try {
                input = scanner.nextDouble();
                if (input < min || input > max) {
                    System.out.println("Error! Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error! Invalid numeric value. Try again.");
                scanner.next(); // Clear invalid input
                input = min - 1; // Set input to be outside of the valid range to continue the loop
            }
        } while (input < min || input > max);
        return input;
    }

    public int getIntWithinRange(Scanner scanner) {
        int input;
        do {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                if (input < min || input > max) {
                    System.out.println("Error! Please enter an integer between " + (int) min + " and " + (int) max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error! Invalid integer value. Try again.");
                scanner.next(); // Clear invalid input
                input = (int) min - 1; // Set input to be outside of the valid range to continue the loop
            }
        } while (input < min || input > max);
        return input;
    }
}
