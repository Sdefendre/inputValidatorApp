import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorString extends ValidatorNumeric {
    private String choiceOne;
    private String choiceTwo;

    // Default constructor
    public ValidatorString() {
        super();
    }

    // Specific constructor taking a user prompt param
    public ValidatorString(String prompt) {
        super(prompt);
    }

    // Specific constructor taking a user prompt and two choice params
    public ValidatorString(String prompt, String choiceOne, String choiceTwo) {
        super(prompt);
        this.choiceOne = choiceOne;
        this.choiceTwo = choiceTwo;
    }

    // Method that shows user prompt and returns a non-empty string from the user
    public String getRequiredString() {
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.println(getPrompt());
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Error! This entry is required. Try again.");
            } else if (!isValidPattern(input, "Your Regex Pattern Here")) { // Example use case
                System.out.println("Error! Invalid format. Try again.");
            }
        } while (input.trim().isEmpty() || !isValidPattern(input, "Your Regex Pattern Here"));
        return input;
    }

    // Method that shows user prompt and returns one of the two pre-defined choices
    public String getChoiceString() {
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.println(getPrompt());
            input = sc.nextLine();
            if (!input.equalsIgnoreCase(choiceOne) && !input.equalsIgnoreCase(choiceTwo)) {
                System.out.println("Error! Entry must be '" + choiceOne + "' or '" + choiceTwo + "'. Try again.");
            }
        } while (!input.equalsIgnoreCase(choiceOne) && !input.equalsIgnoreCase(choiceTwo));
        return input;
    }

    // New method to validate a string against a specific regex pattern
    private boolean isValidPattern(String input, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        return m.matches();
    }
}
