import java.util.*;
class Stack{
    private char characterArray[]=new char[50];
    private int top;
    Stack()
    {
        top=-1;
    }
    public void push(char pushValue)
    {
        if(top==50)
        {
            System.out.println("Stack is full");
        }
        else
        {
            top++;
            characterArray[top]=pushValue;
        }
    }
    public char pop()
    {
        char poppedValue;
            poppedValue=characterArray[top];
            top--;
          return poppedValue;
    }
}
public class PallindromeTestStack {
    public static void main(String[] args) {
        // TODO code application logic here
        Stack stack=new Stack();
        System.out.println("Enter the string");
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        int length=input.length();
        if(length%2==0)
        {
            for(int i=0;i<length/2;i++)
            {
                stack.push(input.charAt(i));
            }
            for(int i=length/2;i<length;i++)
            {
                if(input.charAt(i)==stack.pop())
                {
                    continue;
                }
                else
                {
                    System.out.println("String is not pallindrome");
                    return ;
                }
            }
            System.out.println("String is pallindrome");
        }
        else
        {
             for(int i=0;i<length/2;i++)
             {
                stack.push(input.charAt(i));
             }
            for(int i=((length/2)+1);i<length;i++)
            {
                if(input.charAt(i)==stack.pop())
                {
                    continue;
                }
                else
                {
                    System.out.println("string is not pallindrome");
                    return ;
                }
            }
            System.out.println("String is pallindrome");
        }
        return ;
    }
    
}


