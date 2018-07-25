import java.lang.*;
import java.util.*;

interface Calculator {
    public String addition(String firstHexadecimalValue, String secondHexadecimalValue);

    public String subtraction(String firstHexadecimalValue, String secondHexadecimalValue);

    public String multiplication(String firstHexadecimalValue, String secondHexadecimalValue);

    public String division(String firstHexadecimalValue, String secondHexadecimalValue);

    public boolean lessThan(String firstHexadecimalValue, String secondHexadecimalValue);

    public boolean greaterThan(String firstHexadecimalValue, String secondHexadecimalValue);

    public boolean equals(String firstHexadecimalValue, String secondHexadecimalValue);

    public int hexadecimalToDecimal(String hexadecimalValue);

    public String decimalToHexadecimal(String decimalValue);
}

class HexadecimalOperations implements Calculator {
    private final char TEN = 'A';
    private final char ELEVEN = 'B';
    private final char TWELVE = 'C';
    private final char THIRTEEN = 'D';
    private final char FOURTEEN = 'E';
    private final char FIFTEEN = 'F';

    /**
     * converts hexadecimal to decimal number
     * 
     * @param hexadecimalValue
     * @return decimalValue
     */
    public int hexadecimalToDecimal(String hexadecimalValue) {
        int value;
        int decimalValue = 0, exponent = 0;
        for (int i = hexadecimalValue.length() - 1; i >= 0; i--) {
            if (hexadecimalValue.charAt(i) == TEN) {
                value = 10;
            } else if (hexadecimalValue.charAt(i) == ELEVEN) {
                value = 11;
            } else if (hexadecimalValue.charAt(i) == TWELVE) {
                value = 12;
            } else if (hexadecimalValue.charAt(i) == THIRTEEN) {
                value = 13;
            } else if (hexadecimalValue.charAt(i) == FOURTEEN) {
                value = 14;
            } else if (hexadecimalValue.charAt(i) == FIFTEEN) {
                value = 15;
            } else {
                value = Integer.parseInt(String.valueOf(hexadecimalValue.charAt(i)));
            }
            decimalValue = decimalValue + value * (int) Math.pow(16, exponent);
            exponent++;
        }
        return decimalValue;
    }

    /**
     * converts decimal to hexadecimal number
     * 
     * @param decimalString
     * @return hexadecimalString
     */
    public String decimalToHexadecimal(String decimalString) {
        int hexadecimalValue;
        int decimalValue = Integer.parseInt(decimalString);
        StringBuilder hexadecimalString = new StringBuilder();
        char character;
        hexadecimalValue = decimalValue % 16;
        while (hexadecimalValue > 0) {
            hexadecimalValue = decimalValue % 16;
            if (hexadecimalValue >= 10 && hexadecimalValue <= 15) {
                character = (char) (hexadecimalValue + 55);
            } else {
                character = (char) (hexadecimalValue + 48);
            }
            hexadecimalString.append(Character.toString(character));
            decimalValue = decimalValue / 16;
        }
        hexadecimalString.reverse();
        return hexadecimalString.toString();
    }

    /**
     * performs addition of two hexadecimal number
     * 
     * @param firstHexadecimalValue, secondHexadecimalValue
     * @return sumValue
     */
    public String addition(String firstHexadecimalValue, String secondHexadecimalValue) {
        int firstDecimalValue = hexadecimalToDecimal(firstHexadecimalValue);
        int secondDecimalValue = hexadecimalToDecimal(secondHexadecimalValue);
        int sumValue = firstDecimalValue + secondDecimalValue;
        return decimalToHexadecimal(Integer.toString(sumValue));
    }

    /**
     * performs subtraction of two hexadecimal number
     * 
     * @param firstHexadecimalValue, secondHexadecimalValue
     * @return sumValue
     */
    public String subtraction(String firstHexadecimalValue, String secondHexadecimalValue) {
        int firstDecimalValue = hexadecimalToDecimal(firstHexadecimalValue);
        int secondDecimalValue = hexadecimalToDecimal(secondHexadecimalValue);
        int sumValue;
        if (firstDecimalValue > secondDecimalValue) {
            sumValue = firstDecimalValue - secondDecimalValue;
        } else {
            sumValue = secondDecimalValue - firstDecimalValue;
        }
        return decimalToHexadecimal(Integer.toString(sumValue));
    }

    /**
     * performs multiplication of two hexadecimal number
     * 
     * @param firstHexadecimalValue, secondHexadecimalValue
     * @return sumValue
     */
    public String multiplication(String firstHexadecimalValue, String secondHexadecimalValue) {
        int firstDecimalValue = hexadecimalToDecimal(firstHexadecimalValue);
        int secondDecimalValue = hexadecimalToDecimal(secondHexadecimalValue);
        int sumValue = firstDecimalValue * secondDecimalValue;
        return decimalToHexadecimal(Integer.toString(sumValue));
    }

    /**
     * performs division of two hexadecimal number
     * 
     * @param firstHexadecimalValue, secondHexadecimalValue
     * @return sumValue
     */
    public String division(String firstHexadecimalValue, String secondHexadecimalValue) {
        int firstDecimalValue = hexadecimalToDecimal(firstHexadecimalValue);
        int secondDecimalValue = hexadecimalToDecimal(secondHexadecimalValue);
        if (secondDecimalValue == 0) {
            System.out.println("Invalid denominator");
            return "invalid";
        }
        int sumValue = firstDecimalValue / secondDecimalValue;
        return decimalToHexadecimal(Integer.toString(sumValue));
    }

    /**
     * compares first hexadecimal no with second to check if small
     * 
     * @param firstHexadecimalValue, secondHexadecimalValue
     */
    public boolean lessThan(String firstHexadecimalValue, String secondHexadecimalValue) {
        int lengthOfFirstHexadecimalValue = firstHexadecimalValue.length();
        int lengthOfSecondHexadecimalValue = secondHexadecimalValue.length();
        boolean result = true;
        if (lengthOfFirstHexadecimalValue < lengthOfSecondHexadecimalValue) {
            result = true;
        } else if (lengthOfFirstHexadecimalValue > lengthOfSecondHexadecimalValue) {
            result = false;
        } else {
            int i = 0;
            while (i < lengthOfFirstHexadecimalValue) {

                if (firstHexadecimalValue.charAt(i) > secondHexadecimalValue.charAt(i)) {
                    result = false;
                    break;
                } else if (firstHexadecimalValue.charAt(i) < secondHexadecimalValue.charAt(i)) {
                    result = true;
                    break;
                }
                i++;
            }
            if (i == lengthOfFirstHexadecimalValue) {
                result = false;
            }
        }
        return result;
    }

    /**
     * compares first hexadecimal no with second to check if large
     * 
     * @param firstHexadecimalValue, secondHexadecimalValue
     */
    public boolean greaterThan(String firstHexadecimalValue, String secondHexadecimalValue) {

        int lengthOfFirstHexadecimalValue = firstHexadecimalValue.length();
        int lengthOfSecondHexadecimalValue = secondHexadecimalValue.length();
        boolean result = true;
        if (lengthOfFirstHexadecimalValue > lengthOfSecondHexadecimalValue) {
            result = true;
        } else if (lengthOfFirstHexadecimalValue < lengthOfSecondHexadecimalValue) {
            result = false;
        } else {
            int i = 0;
            while (i < lengthOfFirstHexadecimalValue) {

                if (firstHexadecimalValue.charAt(i) < secondHexadecimalValue.charAt(i)) {
                    result = false;
                    break;
                } else if (firstHexadecimalValue.charAt(i) > secondHexadecimalValue.charAt(i)) {
                    result = true;
                    break;
                }
                i++;
            }
            if (i == lengthOfFirstHexadecimalValue) {
                result = false;
            }
        }
        return result;
    }

    /**
     * compares first hexadecimal no with second to check for equality
     * 
     * @param firstHexadecimalValue, secondHexadecimalValue
     */
    public boolean equals(String firstHexadecimalValue, String secondHexadecimalValue) {
        if (firstHexadecimalValue.equals(secondHexadecimalValue)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * operation checks if hexadecimalValue no is valid
     * 
     * @param firstHexadecimalValue, secondHexadecimalValue
     */
    public boolean isValid(String hexadecimalValue) {
        for (int i = 0; i < hexadecimalValue.length(); i++) {
            if (((int) hexadecimalValue.charAt(i) >= 48 && (int) hexadecimalValue.charAt(i) <= 57)
                    || ((int) hexadecimalValue.charAt(i) >= 65 && (int) hexadecimalValue.charAt(i) <= 70)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}

public class HexaDecimalCalculator {
    public static void main(String[] args) {
        HexadecimalOperations calculator = new HexadecimalOperations();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter first hexadecimal no");
            String firstHexadecimalValue = sc.next();
            if (calculator.isValid(firstHexadecimalValue)) {
                System.out.println("Enter second hexadecimal no");
                String secondHexadecimalValue = sc.next();
                if (calculator.isValid(secondHexadecimalValue)) {
                    System.out.println("Press:\n 1 for addition hexadecimal no \n 2 for subtraction hexadecimal no\n 3 to multiply 
			hexadecimal no \n 4 to divide hexadecimal no \n 5 to check greater than hexadecimal no + "\n 6 to check less 
			than hexadecimal no \n 7 to check equal to hexadecimal no \n press 8 to exit");
                    int option = sc.nextInt();
                    String result;
                    switch (option) {
                    case 1:
                        result = calculator.addition(firstHexadecimalValue, secondHexadecimalValue);
                        System.out.println("The result of addition is: " + result);
                        break;
                    case 2:
                        result = calculator.subtraction(firstHexadecimalValue, secondHexadecimalValue);
                        System.out.println("The result of subtraction is: " + result);
                        break;
                    case 3:
                        result = calculator.multiplication(firstHexadecimalValue, secondHexadecimalValue);
                        System.out.println("The result of multiplication is: " + result);
                        break;
                    case 4:
                        result = calculator.division(firstHexadecimalValue, secondHexadecimalValue);
                        if (result == "invalid") {
                            break;
                        }
                        System.out.println("The result of division is: " + result);
                        break;
                    case 5:
                        System.out.println("The result of greater than is: " 
			    + calculator.greaterThan(firstHexadecimalValue, secondHexadecimalValue));
                        break;
                    case 6:
                        System.out.println("The result of less than is: " 
			    + calculator.lessThan(firstHexadecimalValue, secondHexadecimalValue));
                        break;
                    case 7:
                        System.out.println("The result of equals is: "
                            + calculator.equals(firstHexadecimalValue, secondHexadecimalValue));
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    }
                } else {
                    System.out.println("Invalid no.Enter Valid Hexadecimal no");
                }
            } else {
                System.out.println("Invalid no. Enter Valid Hexadecimal no");
            }
        } while (true);
    }
}
