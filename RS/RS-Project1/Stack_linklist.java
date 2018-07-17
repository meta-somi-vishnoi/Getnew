
import java.util.*;
class list_stack
{
    private LinkedList<Integer> stk=new LinkedList<Integer>();
    public void push(Integer push_val)
    {
        stk.add(push_val);
    }
    public void pop()
    {
        if(stk.isEmpty())
            System.out.println("Stack is Empty");
        else
            stk.removeLast();
    }
    public void top()
    {
        System.out.println(stk.getLast());
    }
    public void isEmpty()
    {
        if(stk.isEmpty())
            System.out.println("Stack is Empty");
        else
            System.out.println("Stack is not Empty");
    }
    public void print()
    {
        for(int i=0;i<stk.size();i++)
            System.out.println(stk.get(i));
    }
}
/**
 *
 * @author vishn_000
 */
public class Stack_linklist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        list_stack stack=new list_stack();
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

