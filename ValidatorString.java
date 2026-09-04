import java.util.Scanner;

public class ValidatorString extends ValidatorNumeric {
    private String choiceOne;
    private String choiceTwo;

    public ValidatorString() {
        super("", 0.0, 0.0);
    }

    public ValidatorString(String prompt) {
        super(prompt, 0.0, 0.0);
    }

    public ValidatorString(String prompt, String choiceOne, String choiceTwo) {
        super(prompt, 0.0, 0.0);
        this.choiceOne = choiceOne;
        this.choiceTwo = choiceTwo;
    }

    public String getRequiredString(Scanner scanner, String emptyErrorMessage, String invalidFormatMessage, String regexPattern) {
        while (true) {
            System.out.print(getPrompt());
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println(emptyErrorMessage);
            } else if (!input.matches(regexPattern)) {
                System.out.println(invalidFormatMessage);
            } else {
                return input;
            }
        }
    }

    public String getChoiceString(Scanner scanner, String invalidChoiceMessage) {
        while (true) {
            System.out.print(getPrompt());
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase(choiceOne) && !input.equalsIgnoreCase(choiceTwo)) {
                System.out.println(invalidChoiceMessage);
            } else {
                return input;
            }
        }
    }
}
