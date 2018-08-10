package undirectedweightedgraphimplementation;

import java.util.*;

class StackUsingLinkList<T> implements StackInterface<T> {

    private Node top;

    StackUsingLinkList() {
        top = null;
    }

    public void pushInStack(T pushValue) {
        Node newNode = new Node(pushValue, top);
        top = newNode;
    }

    public T popFromStack() {
        Node delete = null;
        if (isStackEmpty()) {
            System.out.println("Stack is empty");
        } else {
            delete = top;
            top = top.next;
        }
        return (T) delete.data;
    }

    public boolean isStackEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }

    public T getTop() {
        return (T) top.data;
    }
}