import java.util.Scanner;

public class ValidatorNumeric {
    private String prompt;
    private double min;
    private double max;

    // Constructor for ValidatorNumeric
    public ValidatorNumeric(String prompt, double min, double max) {
        this.prompt = prompt;
        this.min = min;
        this.max = max;
    }

    // Method to get an integer within range
    public int getIntWithinRange(Scanner scanner) {
        int input;
        while (true) {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Error! Invalid integer value. Try again.");
                scanner.next(); // move scanner past the invalid input
                System.out.print(prompt);
            }
            input = scanner.nextInt();
            if (input >= min && input <= max) {
                break;
            } else {
                System.out.println("Error! Please enter a number between " + min + " and " + max + ".");
            }
        }
        return input;
    }

    // Method to get a double within range
    public double getDoubleWithinRange(Scanner scanner) {
        double input;
        while (true) {
            System.out.print(prompt);
            while (!scanner.hasNextDouble()) {
                System.out.println("Error! Invalid decimal value. Try again.");
                scanner.next(); // move scanner past the invalid input
                System.out.print(prompt);
            }
            input = scanner.nextDouble();
            if (input >= min && input <= max) {
                break;
            } else {
                System.out.println("Error! Please enter a number between " + min + " and " + max + ".");
            }
        }
        return input;
    }
}
