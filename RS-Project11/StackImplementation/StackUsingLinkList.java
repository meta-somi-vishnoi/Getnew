package stackImplementation;

import java.util.*;

class Node {
    int data;
    Node next;
}

class StackUsingLinkList {

    private Node top;

    StackUsingLinkList() {
        top = null;
    }

    public int pushInStack(int pushValue) {
        Node newNode = new Node();
        newNode.data = pushValue;
        newNode.next = top;
        top = newNode;
        return topOfStack();
    }

    public int popFromStack() {
        if (isStackEmpty()) {
            return -1;
        } else {
            Node delete = null;
            delete = top;
            top = top.next;
            return delete.data;
        }
    }

    public boolean isStackEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }

    public int topOfStack() {
        if (top == null) {
            return -1;
        }
        return top.data;
    }
}