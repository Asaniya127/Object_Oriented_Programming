// Program to Check Palindrome String

class PalindromeChecker {
    String text;

    // Constructor to initialize text
    PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check if text is a palindrome
    boolean isPalindrome() {
        String cleanText = text.replaceAll("\\s+", "").toLowerCase(); // remove spaces & lowercase
        String reversed = new StringBuilder(cleanText).reverse().toString();
        return cleanText.equals(reversed);
    }

    // Method to display result
    void displayResult() {
        if (isPalindrome()) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }
}

public class PallindromeStrings {
    public static void main(String[] args) {
        PalindromeChecker p1 = new PalindromeChecker("Madam");
        PalindromeChecker p2 = new PalindromeChecker("Hello");
        PalindromeChecker p3 = new PalindromeChecker("A man a plan a canal Panama");

        p1.displayResult();
        p2.displayResult();
        p3.displayResult();
    }
}
