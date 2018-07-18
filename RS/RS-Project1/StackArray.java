class Stack{
    private int stackArray[]=new int[50];
    private int top;
    stack()
    {
        top=-1;
    }
    public void push(int pushValue)
    {
        if(top==50)
        {
            System.out.println("Stack is full");
        }
        else
        {
            top++;
            stackArray[top]=pushValue;
        }
    }
    public int pop()
    {
        int poppedValue;
        if(top==-1)
        {
            System.out.println("Stack is empty");
            return 0;
        }
        else
        {
            poppedValue=stackArray[top];
            top--;
        }
        return poppedValue;
    }
    public void isEmpty()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
        }
        else
        {
            System.out.println("Stack is not empty");
        }
    }
    public void topValue()
    {
        System.out.println(stackArray[top]);
    }
    public void printStack()
    {
        for(int i=top;i>-1;i--)
        {
            System.out.println(stackArray[i]);
        }
    }
}

public class StackArray {
    public static void main(String[] args) {
        // TODO code application logic here
        Stack stack=new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.topValue();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.isEmpty();
    }
    
}
