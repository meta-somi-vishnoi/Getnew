package stackAndQueueImplementation;

import java.util.*;

class PostfixEvaluation {

    /**
     * performs operation on stack values
     * 
     * @param character, stack
     */
    public void postfixOperation(String character, StackUsingLinkList<Integer> stack) {
        Integer result = 0;
        Integer firstValue = 0;
        Integer secondValue = 0;
        if (!stack.isStackEmpty()) {
            firstValue = (Integer) stack.popFromStack();
        } else {
            throw new AssertionError("Stack is empty. Operand not found");
        }
        if (!stack.isStackEmpty()) {
            secondValue = (Integer) stack.popFromStack();
        } else {
            throw new AssertionError("Stack is empty. Operand not found");
        }
        switch (character.charAt(0)) {
        case '*':
            result = secondValue * firstValue;
            break;
        case '/':
            result = secondValue / firstValue;
            break;
        case '+':
            result = secondValue + firstValue;
            break;
        case '-':
            result = secondValue - firstValue;
            break;
        case '^':
            result = (int) Math.pow(secondValue, firstValue);
            break;
        }
        stack.pushInStack(result);
    }

    /**
     * evaluates postfix expression
     * 
     * @param postfix expression
     * @return result
     */
    public double postfixEvaluation(String expression) {
        StackUsingLinkList<Integer> stack = new StackUsingLinkList<Integer>();
        String[] splitExpression = expression.split(" ");
        int countOperand = 0;
        int countOperator = 0;
        for (int i = 0; i < splitExpression.length; i++) {
            if (splitExpression[i].matches("[0-9]+") == true) {
                countOperand++;
            } else if (splitExpression[i].equals("*") || splitExpression[i].equals("/") || splitExpression[i].equals("+") ||
                splitExpression[i].equals("-") || splitExpression[i].equals("^")) {
                countOperator++;
            } else {
                throw new AssertionError("Operand or operator is invalid");
            }
        }
        if (countOperand != countOperator + 1) {
            throw new AssertionError("Invalid Expression");
        }
        for (int i = 0; i < splitExpression.length; i++) {
            if (splitExpression[i].equals("*") || splitExpression[i].equals("/") || splitExpression[i].equals("+") ||
                splitExpression[i].equals("-") || splitExpression[i].equals("^")) {
                postfixOperation(splitExpression[i], stack);
            } else {
                int value = Integer.parseInt(splitExpression[i]);
                stack.pushInStack(value);
            }
        }
        return stack.popFromStack();
    }
}