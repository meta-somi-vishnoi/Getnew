class stack{
    private int arr[]=new int[50];
    private int top;
    stack()
    {
        top=-1;
    }
    public void push(int push_val)
    {
        if(top==50)
        {
            System.out.println("Stack is full");
        }
        else
        {
            top++;
            arr[top]=push_val;
        }
    }
    public int pop()
    {
        int popped_val;
        if(top==-1)
        {
            System.out.println("Stack is empty");
            return 0;
        }
        else
        {
            popped_val=arr[top];
            top--;
        }
        return popped_val;
    }
    public void is_Empty()
    {
        if(top==-1)
            System.out.println("Stack is empty");
        else
            System.out.println("Stack is not empty");
    }
    public void top_val()
    {
        System.out.println(arr[top]);
    }
    public void print_stk()
    {
        for(int i=top;i>-1;i--)
            System.out.println(arr[i]);
    }
}
/**
 *
 * @author vishn_000
 */
public class Stack_array {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        stack stk=new stack();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.top_val();
        stk.print_stk();
        stk.pop();
        stk.print_stk();
        stk.pop();
        stk.pop();
        stk.print_stk();
        stk.pop();
        stk.is_Empty();
    }
    
}
