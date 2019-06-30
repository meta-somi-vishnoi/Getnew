import java.util.*;
class ListStack {
    private LinkedList<Integer> stack = new LinkedList<Integer>();
    
    public void push(Integer pushValue) {
        stack.add(pushValue);
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty");
        }
        else {
            stack.removeLast();
        }
    }
    
    public void top() {
        System.out.println(stack.getLast());
    }
    
    public void isEmpty() {
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty");
        }
        else {
            System.out.println("Stack is not Empty");
        }
    }
    
    public void print() {
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }
    }
}

public class StackLinkList {
    public static void main(String[] args) {
        // TODO code application logic here
        ListStack stack=new ListStack();
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.top();
        stack.isEmpty();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.pop();
        stack.isEmpty();
    } 
}
