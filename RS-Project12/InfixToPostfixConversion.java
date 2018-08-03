package stackAndQueueImplementation;

class InfixToPostfixConversion {

    /**
     * performs precedence check of operator
     * 
     * @param character
     */
    public int precedence(String character) {
        if (character.equals("!")) {
            return 5;
        } else if (character.equals("*") || character.equals("/")) {
            return 4;
        } else if (character.equals("+") || character.equals("-")) {
            return 3;
        } else if (character.equals("<") || character.equals("<=") || character.equals(">") || character.equals(">=")) {
            return 2;
        } else if (character.equals("==") || character.equals("!=")) {
            return 1;
        } else if (character.equals("&&") || character.equals("||")) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * converts infix to postfix expression
     * 
     * @param infixExpression
     */
    public String postfixConversion(String infixExpression) {
        StackUsingLinkList<String> stack = new StackUsingLinkList<>();
        char character;
        int countOperand = 0;
        int countOperator = 0;
        int countOpenParenthesis = 0;
        int countCloseParenthesis = 0;
        int index = 0;
        String poppedValue;
        StringBuilder postfixExpression = new StringBuilder();
        String[] splitExpression = infixExpression.split(" ");
        for (int i = 0; i < splitExpression.length; i++) {
            if (splitExpression[i].matches("[0-9]+") == true) {
                countOperand++;
            } else if (splitExpression[i].equals("*") || splitExpression[i].equals("/") || splitExpression[i].equals("+") ||
                splitExpression[i].equals(">") || splitExpression[i].equals(">=") || splitExpression[i].equals("<") ||
                splitExpression[i].equals("<=") || splitExpression[i].equals("-") || splitExpression[i].equals("!") ||
                splitExpression[i].equals("==") || splitExpression[i].equals("!=") || splitExpression[i].equals("&&") ||
                splitExpression[i].equals("||")) {
                countOperator++;
            } else if (splitExpression[i].equals("(")) {
                countOpenParenthesis++;
            } else if (splitExpression[i].equals(")")) {
                countCloseParenthesis++;
            } else {
                throw new AssertionError("Operand or operator is invalid");
            }
        }
        if (countOperand != countOperator + 1 || countOpenParenthesis != countCloseParenthesis) {
            throw new AssertionError("Invalid Expression");
        }
        for (int i = 0; i < splitExpression.length; i++) {
            if (splitExpression[i].equals("*") || splitExpression[i].equals("/") || splitExpression[i].equals("+") ||
                splitExpression[i].equals(">") || splitExpression[i].equals(">=") || splitExpression[i].equals("<") ||
                splitExpression[i].equals("<=") || splitExpression[i].equals("-") || splitExpression[i].equals("!") ||
                splitExpression[i].equals("==") || splitExpression[i].equals("!=") || splitExpression[i].equals("&&") ||
                splitExpression[i].equals("||")) {
                if (stack.isStackEmpty() || precedence(splitExpression[i]) > precedence(stack.getTop())) {
                    stack.pushInStack(splitExpression[i]);
                } else {
                    if (stack.isStackEmpty()) {
                        throw new AssertionError("Invalid expression");
                    }
                    while (!stack.isStackEmpty() && precedence(stack.getTop()) >= precedence(splitExpression[i])) {
                        postfixExpression.append(stack.popFromStack());
                        postfixExpression.append(" ");
                    }
                    stack.pushInStack(splitExpression[i]);
                }
            } else if (splitExpression[i].equals("(")) {
                stack.pushInStack(splitExpression[i]);
            } else if (splitExpression[i].equals(")")) {
                poppedValue = stack.popFromStack();
                if (poppedValue.equals("(")) {
                    throw new AssertionError("invalid expression. Parenthesis mismatch");
                }
                while (!poppedValue.equals("(")) {
                    postfixExpression.append(poppedValue);
                    postfixExpression.append(" ");
                    if (stack.isStackEmpty()) {
                        throw new AssertionError("invalid expression. Parenthesis mismatch");
                    }
                    poppedValue = stack.popFromStack();
                }
            } else {
                postfixExpression.append(splitExpression[i]);
                postfixExpression.append(" ");
            }
        }
        while (!stack.isStackEmpty()) {
            poppedValue = stack.popFromStack();
            if ( stack.popFromStack().equals("(")) {
                throw new AssertionError("Invalid expression.");
            }
            postfixExpression.append(poppedValue);
            postfixExpression.append(" ");
        }
        return postfixExpression.toString();
    }
}