import java.util.*;
/**
 *perform operations on strings
*/  
class StringOperations{

	/**
	 * check strings for equality 
	 * @param  string1 assumes not null, string2 assumes not null 
	 * @return  1 if true and 0 if false
	*/  
    public int stringEqual(String string1, String string2)
    {
        int length;
        if(string1.length() > string2.length()) {
            length = string1.length();
        }
        else {
            length = string2.length();
        }
        for(int i = 0; i < length; i++) {
            if(string1.charAt(i) == string2.charAt(i)) {
                continue;
            }
            else {
                return 0;
            }
        }
        return 1;
    }
    
    /**
	 * reverse the order of string
	 * @param  string1 assumes not null
	 * @return  reversed string
	*/  
    public String stringReverse(String string1)
    {
        String reverseString = "";
        for(int i=string1.length() - 1; i >= 0; i--) {
            reverseString = reverseString + Character.toString(string1.charAt(i));
        }
        return reverseString;
    }
    
    /**
	 * reverse the case of String
	 * @param  string1 assumes not null
	 * @return  reversed case string
	*/  
    public String reverseStringCase(String string1)
    {
        String reverseCaseString = "";
        char character;
        for(int i = 0;i < string1.length(); i++) {
            character = string1.charAt(i);
            if((int)character >= 65 && (int)character <= 90) {
                reverseCaseString = reverseCaseString + Character.toString((char)((int)character + 32));
            }
            else if((int)character>=97 && (int)character<=122){
                reverseCaseString = reverseCaseString + Character.toString((char)((int)character - 32));
            }
        }
        return reverseCaseString;
    }
    
    /**
	 * finds largest word in string
	 * @param  string1 assumes not null
	 * @return  largest word of string
	*/  
    public String largestWord(String string1)
    {
        String largestWord;
        int startIndex = 0;
        int endIndex = 0;
        int maximumLength = 0;
        int length; 
        int wordStartIndex = 0;
        int wordEndIndex = 0;
        int start = 0;
        for(int i = start; i < string1.length(); i++) {
            if((int)string1.charAt(i) == 32 || ((i == string1.length() - 1) && (int)string1.charAt(string1.length()-1) != 32)) {
                endIndex = i;
                if((i == string1.length() - 1)) {
                	endIndex++;
                }
                length = endIndex-startIndex;
                if(length >= maximumLength) {
                    maximumLength = length;
                    wordStartIndex = startIndex;
                    wordEndIndex = endIndex;
                }
                while((int)string1.charAt(i) == 32) {
                    i++;
                }
                startIndex = i;
            }
        }
        largestWord = string1.substring(wordStartIndex,wordEndIndex);
        return largestWord;
    }
}

public class StringComparison {
    public static void main(String[] args) {
        StringOperations operations = new StringOperations();
        String string1, string2, result;
        int option, answer;
        do {
        	Scanner sc = new Scanner(System.in);
        	Scanner integer = new Scanner(System.in);
        	System.out.println("Enter first string ");
            string1 = sc.nextLine();
            if(string1 == null) {
            	throw new IllegalArgumentException("The string cannot be null");
            }
            System.out.println("Choose option: \n 1. To check for equality \n 2. To find reverse of string \n 3. To replace case of string \n 4. To return Maximum length word in string");
            option = integer.nextInt();
            switch(option)
            {
                case 1: System.out.println("Enter string to be compared");
                        string2 = sc.next();
                        if(string1 == null) {
                        	throw new IllegalArgumentException("The string cannot be null");
                        }
                        answer = operations.stringEqual(string1, string2);
                        if(answer == 1) {
                            System.out.println("The strings are equal"); 
                        }
                        else {
                            System.out.println("The strings are  not equal");
                        }
                        break;
                case 2: result = operations.stringReverse(string1);
                        System.out.println("Reversed string is " + result);
                        break;
                case 3: result = operations.reverseStringCase(string1);
                        System.out.println("Reversed case string is " + result);
                        break;
                case 4: result = operations.largestWord(string1);
                        System.out.println("Largest word in string is " + result);
                        break;
                case 5: System.exit(0);
            }
        }while(true);
    }
    
}
