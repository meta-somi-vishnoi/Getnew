import java.util.*;

/**
 * perform operations on strings
 */
class StringOperations {

    /**
     * check strings for equality
     * 
     * @param firstString assumes not null, secondString assumes not null
     * @return 1 if true and 0 if false
     */
    public int stringEqual(String firstString, String secondString) {
        int lengthOfString;
        if (firstString.length() > secondString.length()) {
            lengthOfString = firstString.length();
        } else {
            lengthOfString = secondString.length();
        }
        for (int i = 0; i < lengthOfString; i++) {
            if (firstString.charAt(i) == secondString.charAt(i)) {
                continue;
            } else {
                return 0;
            }
        }
        return 1;
    }

    /**
     * reverse the order of string
     * 
     * @param firstString assumes not null
     * @return reversed string
     */
    public String stringReverse(String firstString) {
        String reverseString = "";
        for (int i = firstString.length() - 1; i >= 0; i--) {
            reverseString = reverseString + Character.toString(firstString.charAt(i));
        }
        return reverseString;
    }

    /**
     * reverse the case of String
     * 
     * @param firstString
     *            assumes not null
     * @return reversed case string
     */
    public String reverseStringCase(String firstString) {
        String reverseCaseString = "";
        char character;
        for (int i = 0; i < firstString.length(); i++) {
            character = firstString.charAt(i);
            if ((int) character >= 65 && (int) character <= 90) {
                reverseCaseString = reverseCaseString + Character.toString((char) ((int) character + 32));
            } else if ((int) character >= 97 && (int) character <= 122) {
                reverseCaseString = reverseCaseString + Character.toString((char) ((int) character - 32));
            }
        }
        return reverseCaseString;
    }

    /**
     * finds largest word in string
     * 
     * @param firstString
     *            assumes not null
     * @return largest word of string
     */
    public String largestWord(String firstString) {
        String largestWord;
        int startIndex = 0;
        int endIndex = 0;
        int maximumLength = 0;
        int lengthOfString;
        int wordStartIndex = 0;
        int wordEndIndex = 0;
        int start = 0;
        for (int i = start; i < firstString.length(); i++) {
            if ((int) firstString.charAt(i) == 32
                    || ((i == firstString.length() - 1) && (int) firstString.charAt(firstString.length() - 1) != 32)) {
                endIndex = i;
                if ((i == firstString.length() - 1)) {
                    endIndex++;
                }
                lengthOfString = endIndex - startIndex;
                if (lengthOfString >= maximumLength) {
                    maximumLength = lengthOfString;
                    wordStartIndex = startIndex;
                    wordEndIndex = endIndex;
                }
                while ((int) firstString.charAt(i) == 32) {
                    i++;
                }
                startIndex = i;
            }
        }
        largestWord = firstString.substring(wordStartIndex, wordEndIndex);
        return largestWord;
    }
}

public class StringComparison {
    public static void main(String[] args) {
        StringOperations operations = new StringOperations();
        String firstString, secondString, result;
        int option, answer;
        do {
            Scanner sc = new Scanner(System.in);
            Scanner integer = new Scanner(System.in);
            System.out.println("Enter first string ");
            firstString = sc.nextLine();
            if (firstString == null) {
                throw new IllegalArgumentException("The string cannot be null");
            }
            System.out.println("Choose option: \n 1. To check for equality \n 2. To find reverse of string \n 
		3. To replace case of string \n 4. To return Maximum length word in string");
            option = integer.nextInt();
            switch (option) {
            case 1:
                System.out.println("Enter string to be compared");
                secondString = sc.next();
                if (firstString == null) {
                    throw new IllegalArgumentException("The string cannot be null");
                }
                answer = operations.stringEqual(firstString, secondString);
                if (answer == 1) {
                    System.out.println("The strings are equal");
                } else {
                    System.out.println("The strings are  not equal");
                }
                break;
            case 2:
                result = operations.stringReverse(firstString);
                System.out.println("Reversed string is " + result);
                break;
            case 3:
                result = operations.reverseStringCase(firstString);
                System.out.println("Reversed case string is " + result);
                break;
            case 4:
                result = operations.largestWord(firstString);
                System.out.println("Largest word in string is " + result);
                break;
            case 5:
                System.exit(0);
            }
        } while (true);
    }
}
