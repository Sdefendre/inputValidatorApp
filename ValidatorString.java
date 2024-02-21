import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorString extends ValidatorNumeric {
    private String choiceOne;
    private String choiceTwo;
    private Scanner scanner; // For reuse

    public ValidatorString() {
        super("", 0.0, 0.0); // Call super constructor with default values
        scanner = new Scanner(System.in);
    }

    public ValidatorString(String prompt) {
        super(prompt, 0.0, 0.0); // Call super constructor with prompt
        scanner = new Scanner(System.in);
    }

    public ValidatorString(String prompt, String choiceOne, String choiceTwo) {
        super(prompt, 0.0, 0.0); // Call super constructor with prompt 
        this.choiceOne = choiceOne;
        this.choiceTwo = choiceTwo;
        scanner = new Scanner(System.in);
    }

    public String getRequiredString(String emptyErrorMessage, String invalidFormatMessage) {
        String input;
        do {
            System.out.println(getPrompt());
            input = scanner.nextLine(); 
            if (input.trim().isEmpty()) {
                System.out.println(emptyErrorMessage);
            } else if (!isValidPattern(input, "Your Regex Pattern Here")) { 
                System.out.println(invalidFormatMessage);
            }
        } while (input.trim().isEmpty() || !isValidPattern(input, "Your Regex Pattern Here"));
        return input;
    }

    public String getChoiceString(String invalidChoiceMessage) {
        String input;
        do {
            System.out.println(getPrompt());
            input = scanner.nextLine(); 
            if (!input.equalsIgnoreCase(choiceOne) && !input.equalsIgnoreCase(choiceTwo)) {
                System.out.println(invalidChoiceMessage);
            }
        } while (!input.equalsIgnoreCase(choiceOne) && !input.equalsIgnoreCase(choiceTwo));
        return input;
    }

    private String getPrompt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the prompt: ");
        String prompt = scanner.nextLine();
        // close the scanner 
        scanner.close();
        return prompt;
    }

    // New method to validate a string against a specific regex pattern
    private boolean isValidPattern(String input, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        return m.matches();
    }
}
