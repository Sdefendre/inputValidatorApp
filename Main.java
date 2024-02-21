import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Validation Tester application\n");

        runIntegerTest(scanner);
        runDoubleTest(scanner); 
        runRequiredStringTest(scanner);
        runChoiceStringTest(scanner);

        System.out.println("\nAll done!");
        scanner.close();
    }

    private static void runIntegerTest(Scanner scanner) {
        System.out.println("Int Test");
        ValidatorNumeric intValidator = new ValidatorNumeric("Enter an integer between -100 and 100: ", -100, 100);
        int intValue;
    
        do {
            intValue = intValidator.getIntWithinRange(scanner);
            if (intValue != Integer.MIN_VALUE) {
                System.out.println("You entered: " + intValue);
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        } while (intValue == Integer.MIN_VALUE);
    }
    

    // run the double test
    private static void runDoubleTest(Scanner scanner) {
        System.out.println("Double Test");
        ValidatorNumeric doubleValidator = new ValidatorNumeric("Enter any number between -100 and 100: ", -100, 100);
        double doubleValue = doubleValidator.getNumberWithinRange(scanner);
        System.out.println("You entered: " + doubleValue);
    }
// run the required string test
private static void runRequiredStringTest(Scanner scanner) {
    System.out.println("Name Test");
    ValidatorString nameValidator = new ValidatorString("Enter your name: ");
    String name = nameValidator.getRequiredString(scanner, "Name is required.", "Invalid name format.", "[A-Za-z ]+");
    System.out.println("You entered: " + name);

    System.out.println("\nEmail Test");
    ValidatorString emailValidator = new ValidatorString("Enter your email address: ");
    String email = emailValidator.getRequiredString(scanner, "Email is required.", "Invalid email format.", "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$");
    System.out.println("You entered: " + email);
}




    // run the choice string test
    private static void runChoiceStringTest(Scanner scanner) {
        System.out.println("Choice String Test");
        ValidatorString choiceStringValidator = new ValidatorString("Select a color (red, green, blue): ", "red", "green");
        String color = choiceStringValidator.getChoiceString(scanner, "Invalid color.");
        System.out.println("You chose: " + color);
    }

}
