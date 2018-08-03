package stackAndQueueImplementation;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluationTest {

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabled() {
        PostfixEvaluation expression = new PostfixEvaluation();
        assertEquals(expression.postfixEvaluation("32 2 + * 4 -"), 30, 0);
    }

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabledWithInsufficientOperand() {
        PostfixEvaluation expression = new PostfixEvaluation();
        assertEquals(expression.postfixEvaluation("- 32 2 4 -"), 30, 0);
    }

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabledInvalidexpression() {
        PostfixEvaluation expression = new PostfixEvaluation();
        assertEquals(expression.postfixEvaluation("32@ 2 + * 4 -"), 30, 0);
    }

    @Test
    public void testPostfixEvaluationWithReturnValue30() {
        PostfixEvaluation expression = new PostfixEvaluation();
        assertEquals(expression.postfixEvaluation("32 2 + 4 -"), 30, 0);
    }

    @Test
    public void testPostfixEvaluationWithReturnValue109() {
        PostfixEvaluation expression = new PostfixEvaluation();
        assertEquals(expression.postfixEvaluation("13 33 * 4 / 2 +"), 109, 0);
    }

    @Test
    public void testPostfixEvaluationWithReturnValue64() {
        PostfixEvaluation expression = new PostfixEvaluation();
        assertEquals(expression.postfixEvaluation("32 2 5 ^ +"), 64, 0);
    }

    @Test
    public void testPostfixEvaluationWithReturnValue3() {
        PostfixEvaluation expression = new PostfixEvaluation();
        assertNotEquals(expression.postfixEvaluation("2 23 5 ^ +"), 64, 0);
    }
}