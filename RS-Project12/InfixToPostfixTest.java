package stackAndQueueImplementation;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabled() {
        InfixToPostfixConversion expression = new InfixToPostfixConversion();
        String actualOutput = "23 2 1 + 2 - * 3 1 / + ";
        assertEquals(actualOutput, expression.postfixConversion("23 * ( 2 + 1 - 2 ) 5 - / + 3 / 1"));
    }

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabledInvalid() {
        InfixToPostfixConversion expression = new InfixToPostfixConversion();
        String actualOutput = "23 2 1 + 2 - * 3 1 / + ";
        assertEquals(actualOutput, expression.postfixConversion("23 ( * ( 2 + 1 - 2 ) + 3 / 1"));
    }

    @Test
    public void testInfixToPostfix() {
        InfixToPostfixConversion expression = new InfixToPostfixConversion();
        String actualOutput = "23 2 1 + 2 - * 3 1 / + ";
        assertEquals(actualOutput, expression.postfixConversion("23 * ( 2 + 1 - 2 ) + 3 / 1"));
    }

    @Test
    public void testInfixExpression() {
        InfixToPostfixConversion expression = new InfixToPostfixConversion();
        String actualOutput = "78 28 * 33 4 / - ";
        assertEquals(actualOutput, expression.postfixConversion("78 * 28 - 33 / 4"));
    }
    
    @Test
    public void testInfixExpressionOperator() {
        InfixToPostfixConversion expression = new InfixToPostfixConversion();
        String actualOutput = "78 28 33 ! 4 > && ";
        assertEquals(actualOutput, expression.postfixConversion("78 && 28 ! 33 > 4"));
    }
}
