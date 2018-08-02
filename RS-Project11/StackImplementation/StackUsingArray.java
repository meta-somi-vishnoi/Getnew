package stackImplementation;

class StackUsingArray implements StackInterface {
    private int stackArray[] = new int[10];
    private int top = -1;

    public int pushInStack(int pushValue) {
        if (isStackFull()) {
            return -1;
        } else {
            top++;
            stackArray[top] = pushValue;
            return topOfStack();
        }
    }

    public int popFromStack() {
        int poppedValue;
        if (isStackEmpty()) {
            return -1;
        } else {
            poppedValue = stackArray[top];
            top--;
        }
        return poppedValue;
    }

    public boolean isStackEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isStackFull() {
        if (top == (stackArray.length - 1)) {
            return true;
        } else {
            return false;
        }
    }

    public int topOfStack() {
        if (top == -1) {
            return -1;
        }
        return stackArray[top];
    }
}