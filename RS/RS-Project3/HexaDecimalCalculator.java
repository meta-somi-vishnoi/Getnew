import java.lang.*;
import java.util.*;

interface Calculator{
    public String addition(String hexadecimal1,String hexadecimal2);
    public String subtraction(String hexadecimal1,String hexadecimal2);
    public String multiplication(String hexadecimal1,String hexadecimal2);
    public String division(String hexadecimal1,String hexadecimal2);
    public boolean lessThan(String hexadecimal1,String hexadecimal2);
    public boolean greaterThan(String hexadecimal1,String hexadecimal2);
    public boolean equals(String hexadecimal1,String hexadecimal2);
    public int hexadecimalToDecimal(String hexadecimal);
    public String decimalToHexadecimal(String decimal);
}

class HexadecimalOperations implements Calculator
{
    private final char TEN='A';
    private final char ELEVEN='B';
    private final char TWELVE='C';
    private final char THIRTEEN='D';
    private final char FOURTEEN='E';
    private final char FIFTEEN='F';
    /**
	 * converts hexadecimal to decimal number
	 * @param  hexadecimal 
	 * @return  decimalValue
	*/        
    public int hexadecimalToDecimal(String hexadecimal)
    {
        int value;
        int decimalValue=0, exponent=0;
        for(int i=hexadecimal.length()-1;i>=0;i--)
        {
            if(hexadecimal.charAt(i)==TEN) {
                value=10;
            }
            else  if(hexadecimal.charAt(i)==ELEVEN) {
                value=11;
            }
            else  if(hexadecimal.charAt(i)==TWELVE) {
                value=12;
            }
            else  if(hexadecimal.charAt(i)==THIRTEEN) {
                value=13;
            }
            else  if(hexadecimal.charAt(i)==FOURTEEN) {
                value=14;
            }
            else  if(hexadecimal.charAt(i)==FIFTEEN) {
                value=15;
            }
            else {
            	value=Integer.parseInt(String.valueOf(hexadecimal.charAt(i)));
            }
            decimalValue = decimalValue+value*(int)Math.pow(16,exponent);
            exponent++;
        }
        return decimalValue;
    }
    /**
   	 * converts decimal to hexadecimal number
   	 * @param  decimal 
   	 * @return  hexadecimalString
   	*/ 
    public String decimalToHexadecimal(String decimal)
    {
        int hexadecimalValue;
        int decimalValue = Integer.parseInt(decimal);
        StringBuilder hexadecimalString = new StringBuilder();
        char character;
        hexadecimalValue=decimalValue%16;
        while(hexadecimalValue>0)
        {
            hexadecimalValue=decimalValue%16;
            if(hexadecimalValue>=10 && hexadecimalValue<=15) {
                character=(char)(hexadecimalValue+55);
            }
            else {
                character=(char)(hexadecimalValue+48);
            }
            hexadecimalString.append(Character.toString(character));
            decimalValue=decimalValue/16;
        }
        hexadecimalString.reverse();
        return hexadecimalString.toString();
    }
    /**
   	 * performs addition of two hexadecimal number
   	 * @param  hexadecimal1, hexadecimal2 
   	 * @return  sumValue
   	*/ 
    public String addition(String hexadecimal1,String hexadecimal2)
    {
        int decimalValue1 = hexadecimalToDecimal(hexadecimal1);
        int decimalValue2 = hexadecimalToDecimal(hexadecimal2);
        int sumValue = decimalValue1+decimalValue2;
        return decimalToHexadecimal(Integer.toString(sumValue));
    }
    /**
   	 * performs subtraction of two hexadecimal number
   	 * @param  hexadecimal1, hexadecimal2 
   	 * @return  sumValue
   	*/ 
    public String subtraction(String hexadecimal1,String hexadecimal2)
    {
        int decimalValue1 = hexadecimalToDecimal(hexadecimal1);
        int decimalValue2 = hexadecimalToDecimal(hexadecimal2);
        int sumValue;
        if(decimalValue1>decimalValue2) {
            sumValue = decimalValue1-decimalValue2;
        }
        else {
            sumValue = decimalValue2-decimalValue1;
        }
        return decimalToHexadecimal(Integer.toString(sumValue));
    }
    /**
   	 * performs multiplication of two hexadecimal number
   	 * @param  hexadecimal1, hexadecimal2 
   	 * @return  sumValue
   	*/ 
    public String multiplication(String hexadecimal1,String hexadecimal2)
    {
        int decimalValue1 = hexadecimalToDecimal(hexadecimal1);
        int decimalValue2 = hexadecimalToDecimal(hexadecimal2);
        int sumValue = decimalValue1*decimalValue2;
        return decimalToHexadecimal(Integer.toString(sumValue));
    }
    /**
   	 * performs division of two hexadecimal number
   	 * @param  hexadecimal1, hexadecimal2 
   	 * @return  sumValue
   	*/ 
    public String division(String hexadecimal1,String hexadecimal2)
    {
        int decimalValue1 = hexadecimalToDecimal(hexadecimal1);
        int decimalValue2 = hexadecimalToDecimal(hexadecimal2);
        if(decimalValue2==0)
        {
        	System.out.println("Invalid denominator");
        	return "invalid";
        }
        int sumValue = decimalValue1/decimalValue2;
        return decimalToHexadecimal(Integer.toString(sumValue));
    }
    /**
   	 * compares first hexadecimal no with second to check if small
   	 * @param  hexadecimal1, hexadecimal2 
   	*/ 
    public boolean lessThan(String hexadecimal1,String hexadecimal2)
    { 
      int length1=hexadecimal1.length();
      int length2=hexadecimal2.length();
      boolean result=true;
      if(length1<length2) {
      	result=true;
      }
      else if(length1>length2) {
      	result=false;
      }
      else {
      	 int i=0;
      	 while(i<length1)
           {
      		 
               if(hexadecimal1.charAt(i)>hexadecimal2.charAt(i)) {
              	 result=false;
              	 break;
               }
               else if(hexadecimal1.charAt(i)<hexadecimal2.charAt(i)) {
              	 result=true;
              	 break;
               }
               i++;
           }
      	 if(i==length1) {
      		 result=false;
      	 }
      }
      return result;
    }
    /**
   	 * compares first hexadecimal no with second to check if large
   	 * @param  hexadecimal1, hexadecimal2 
   	*/ 
    public boolean greaterThan(String hexadecimal1,String hexadecimal2)
    {
          
        int length1=hexadecimal1.length();
        int length2=hexadecimal2.length();
        boolean result=true;
        if(length1>length2) {
        	result=true;
        }
        else if(length1<length2) {
        	result=false;
        }
        else {
        	 int i=0;
        	 while(i<length1) {
        		 
                 if(hexadecimal1.charAt(i)<hexadecimal2.charAt(i)) {
                	 result=false;
                	 break;
                 }
                 else if(hexadecimal1.charAt(i)>hexadecimal2.charAt(i)) {
                	 result=true;
                	 break;
                 }
                 i++;
             }
        	 if(i==length1) {
        		 result=false;
        	 }
        }
        return result;
    }
    /**
   	 * compares first hexadecimal no with second to check for equality
   	 * @param  hexadecimal1, hexadecimal2 
   	*/ 
    public boolean equals(String hexadecimal1,String hexadecimal2)
    {
        if(hexadecimal1.equals(hexadecimal2)) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
   	 * operation checks if hexadecimal no is valid
   	 * @param  hexadecimal1, hexadecimal2 
   	*/ 
    public boolean isValid(String hexadecimal)
    {
    	for(int i=0;i<hexadecimal.length();i++) {
    		if(((int)hexadecimal.charAt(i)>=48 && (int)hexadecimal.charAt(i)<=57) || ((int)hexadecimal.charAt(i)>=65 && (int)hexadecimal.charAt(i)<=70)) {
    			continue;
    		}
    		else {
    			return false;
    		}
    	}
    	return true;
    }
}
public class HexaDecimalCalculator {
    public static void main(String[] args) {
        // TODO code application logic here
        HexadecimalOperations calculator = new HexadecimalOperations();
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("Enter first hexadecimal no");
            String hexadecimal1=sc.next();
            if(calculator.isValid(hexadecimal1)) {
	            System.out.println("Enter second hexadecimal no");
	            String hexadecimal2=sc.next();
	            if(calculator.isValid(hexadecimal2)) {
		            System.out.println("Press:\n 1 for addition hexadecimal no \n 2 for subtraction hexadecimal no\n 3 to multiply hexadecimal no \n 4 to divide hexadecimal no \n 5 to check greater than hexadecimal no"
		            + "\n 6 to check less than hexadecimal no \n 7 to check equal to hexadecimal no \n press 8 to exit");
		            int option=sc.nextInt();
		            String result;
		            switch(option)
		            {
		                case 1:
		                        result=calculator.addition(hexadecimal1,hexadecimal2);
		                        System.out.println("The result of addition is: "+result);
		                        break;
		                case 2: 
		                        result=calculator.subtraction(hexadecimal1,hexadecimal2);
		                        System.out.println("The result of subtraction is: "+result);
		                        break;
		                case 3: 
		                        result=calculator.multiplication(hexadecimal1,hexadecimal2);
		                        System.out.println("The result of multiplication is: "+result);
		                        break;
		                case 4: 
		                        result=calculator.division(hexadecimal1,hexadecimal2);
		                        if(result=="invalid") {
		                        	break;	
		                        }
		                        System.out.println("The result of division is: "+result);
		                        break;
		                case 5:
		                        System.out.println("The result of greater than is: "+ calculator.greaterThan(hexadecimal1,hexadecimal2));
		                        break;
		                case 6: 
		                        System.out.println("The result of less than is: "+ calculator.lessThan(hexadecimal1,hexadecimal2));
		                        break;
		                case 7: 
		                        System.out.println("The result of equals is: "+ calculator.equals(hexadecimal1,hexadecimal2));
		                        break;
		                case 8: System.exit(0);
		                        break;
		            }
	            }
		        else {
		        	System.out.println("Invalid no.Enter Valid Hexadecimal no");
		        }
            }
            else {
            	System.out.println("Invalid no. Enter Valid Hexadecimal no");
            }
        }while(true);
    }
    
}


