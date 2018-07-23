public class LcmAndHcfCalculate {
    private static int multiple = 0;

    LcmAndHcfCalculate() {
        multiple = 0;
    }

    /**
     * calculates lowest common multiples of two numbers
     * 
     * @param assume
     *            number1 >= 0 and number2 >= 0
     * @return lcm of numbers
     */
    public int lcmCalculator(int number1, int number2) {
        multiple += number2;
        if ((multiple % number1) == 0 && (multiple % number2) == 0) {
            return multiple;
        } else {
            return lcmCalculator(number1, number2);
        }
    }

    /**
     * calculates highest common factor of two numbers
     * 
     * @param assume
     *            number1 >= 0 and number2 >= 0
     * @return hcf of numbers
     */
    public int hcfCalculator(int number1, int number2) {
        if (number1 == number2) {
            return number1;
        }
        if (number1 > number2) {
            return hcfCalculator(number1 - number2, number2);
        }
        return hcfCalculator(number1, number2 - number1);
    }
}
