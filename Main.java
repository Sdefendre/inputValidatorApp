import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Welcome Message
        System.out.println("Welcome to the Validation Tester application\n");

        // Integer Test
        System.out.println("Int Test");
        ValidatorNumeric intValidator = new ValidatorNumeric("Enter an integer between -100 and 100: ", -100, 100);
        int intValue = intValidator.getIntWithinRange(scanner);
        System.out.println("You entered: " + intValue);

        // Double Test
        System.out.println("\nDouble Test");
        ValidatorNumeric doubleValidator = new ValidatorNumeric("Enter any number between -100.0 and 100.0: ", -100.0, 100.0);
        double doubleValue = doubleValidator.getDoubleWithinRange(scanner);
        System.out.println("You entered: " + doubleValue);

        // Required String Test
        System.out.println("\nRequired String Test:");
        ValidatorString stringValidator = new ValidatorString("Enter a required string: ");
        String requiredString = stringValidator.getRequiredString(scanner);
        System.out.println("You entered: " + requiredString);

        // String Choice Test
        System.out.println("\nString Choice Test");
        ValidatorString choiceValidator = new ValidatorString("Select one (x/y): ", "x", "y");
        String choiceString = choiceValidator.getChoiceString(scanner);
        System.out.println("You selected: " + choiceString);

        System.out.println("\nAll done!");

        scanner.close();
    }
}