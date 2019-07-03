import java.util.*;

/**
 * calculates area of different figures
 */
class AreaOfFigures {

    /**
     * calculates area of triangle
     * 
     * @param height, width of triangle
     */
    public float areaOfTriangle(float height, float width) {
        return (width * height) / 2;
    }

    /**
     * calculates area of rectangle
     * 
     * @param height, width of rectangle
     */
    public float areaOfRectangle(float height, float width) {
        return (width * height);
    }

    /**
     * calculates area of square
     * 
     * @param width of square
     */
    public float areaOfSquare(float width) {
        return (width * width);
    }

    /**
     * calculates area of circle
     * 
     * @param radius of circle
     */
    public float areaOfCircle(float radius) {
        return ((float) Math.PI * radius * radius);
    }
}

public class Area {

    public static void main(String args[]) {

        float height, width, radius, areaCalculated;
        Scanner sc = new Scanner(System.in);
        AreaOfFigures areaOfFigures = new AreaOfFigures();
        do {
            try {
                System.out.println("ChooseOption: \n 1. Area of Triangle \n 2. Area of Rectangle \n 3. Area of Square \n 
		    4. Area of Circle \n 5. To exit");
                int option = sc.nextInt();
                switch (option) {
                case 1:
                    System.out.println("Enter height of Triangle");
                    height = sc.nextInt();
                    if (height < 0) {
                        throw new ArithmeticException();
                    }
                    System.out.println("Enter width of Triangle");
                    width = sc.nextInt();
                    if (width < 0) {
                        throw new ArithmeticException();
                    }
                    areaCalculated = areaOfFigures.areaOfTriangle(height, width);
                    System.out.println("The area of triangle is :" + areaCalculated);
                    break;
                case 2:
                    System.out.println("Enter height of Rectangle");
                    height = sc.nextInt();
                    if (height < 0) {
                        throw new ArithmeticException();
                    }
                    System.out.println("Enter width of Rectangle");
                    width = sc.nextInt();
                    if (width < 0) {
                        throw new ArithmeticException();
                    }
                    areaCalculated = areaOfFigures.areaOfRectangle(height, width);
                    System.out.println("The area of rectangle is :" + areaCalculated);
                    break;
                case 3:
                    System.out.println("Enter height of Square");
                    height = sc.nextInt();
                    if (height < 0) {
                        throw new ArithmeticException();
                    }
                    areaCalculated = areaOfFigures.areaOfSquare(height);
                    System.out.println("The area of square is :" + areaCalculated);
                    break;
                case 4:
                    System.out.println("Enter radius of Circle");
                    radius = sc.nextInt();
                    if (radius < 0) {
                        throw new ArithmeticException();
                    }
                    areaCalculated = areaOfFigures.areaOfCircle(radius);
                    System.out.println("The area of circle is :" + areaCalculated);
                    break;
                case 5:
                    System.exit(0);
                }
            } catch (ArithmeticException e) {
                System.out.println("Value should be positive.");
                continue;
            } catch (Exception e) {
                System.out.println("Input type is invalid.");
                System.exit(0);
            }
        } while (true);
    }
}
