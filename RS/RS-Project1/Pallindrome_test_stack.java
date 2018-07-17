import java.util.*;
/**
 *
 * @author vishn_000
 */
class stack{
    private char arr[]=new char[50];
    private int top;
    stack()
    {
        top=-1;
    }
    public void push(char push_val)
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
    public char pop()
    {
        char s;
        
            s=arr[top];
            top--;
          return s;
    }
}
public class Pallindrome_test_stack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        stack stk=new stack();
        System.out.println("Enter the string");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int len=str.length();
        if(len%2==0)
        {
            for(int i=0;i<len/2;i++)
                stk.push(str.charAt(i));
            for(int i=len/2;i<len;i++)
            {
                if(str.charAt(i)==stk.pop())
                    continue;
                else
                {
                    System.out.println("string is not pallindrome");
                    return ;
                }
            }
            System.out.println("String is pallindrome");
        }
        else
        {
             for(int i=0;i<len/2;i++)
                stk.push(str.charAt(i));
            for(int i=((len/2)+1);i<len;i++)
            {
                if(str.charAt(i)==stk.pop())
                    continue;
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


