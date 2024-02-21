import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Validation Tester application\n");

        runIntegerTest(scanner);
        //runDoubleTest(scanner); 
        //runRequiredStringTest(scanner);
        //runChoiceStringTest(scanner);

        System.out.println("\nAll done!");
        scanner.close();
    }

    private static void runIntegerTest(Scanner scanner) {
        System.out.println("Int Test");
        ValidatorNumeric intValidator = new ValidatorNumeric("Enter an integer between -100 and 100: ", -100, 100);
        int intValue = intValidator.getIntWithinRange(scanner);
        System.out.println("You entered: " + intValue);
    }

    // ... other test methods (runDoubleTest, etc.)
}
