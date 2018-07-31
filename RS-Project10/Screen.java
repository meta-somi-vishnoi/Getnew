package Graphics;
import java.util.*;

public class Screen {
    
    public static void main(String[] args) {
        int choice;
        int option;
        int length, breadth, radius;
        Point origin;
        int xCoordinate, yCoordinate;
        Scanner string = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Shapes> listOfShapes = new ArrayList<Shapes>();
        ShapesOperations operation = new ShapesOperations();
        System.out.println("Graphics library");
        System.out.println("Choose option");
        System.out.println("1. To add shapes to screen");
        System.out.println("2. To delete shape from screen");
        System.out.println("3. To delete particular shape type from screen");
        System.out.println("4. To display list of shape on screen");
        System.out.println("5. To sort shapes in ascending order");
        Scanner sc = new Scanner(System.in);
        option=sc.nextInt();
        switch(option) {
        case 1:
            System.out.println("1. To create Rectangle");
            System.out.println("2. To create Square");
            System.out.println("3. To create Triangle");
            System.out.println("4. To create Circle");
            choice=sc.nextInt();
            switch(choice) {
            case 1:
                System.out.println("Enter origin x coordinate");
                xCoordinate=sc.nextInt();
                System.out.println("Enter origin y coordinate");
                yCoordinate=sc.nextInt();
                origin = new Point(xCoordinate, yCoordinate);
                System.out.println("Enter length of rectangle");
                length=sc.nextInt();
                System.out.println("Enter breadth of rectangle");
                breadth=sc.nextInt();
                if(!operation.checkCoordinates(xCoordinate+length, yCoordinate+breadth)) {
                    System.out.println("coordinates are wrong");
                    System.exit(0);
                }
                list.add(0,length);
                list.add(1,breadth);
                listOfShapes.add(ShapesFactory.createShape("Rectangle", origin, list));
                System.out.println("Shape added successfully");
                break;
            case 2:
                System.out.println("Enter origin x coordinate");
                xCoordinate=sc.nextInt();
                System.out.println("Enter origin y coordinate");
                yCoordinate=sc.nextInt();
                origin = new Point(xCoordinate, yCoordinate);
                System.out.println("Enter length of square");
                length=sc.nextInt();
                list.add(2,length);
                if(!operation.checkCoordinates(xCoordinate+length, yCoordinate+length)) {
                    System.out.println("coordinates are wrong");
                    System.exit(0);
                }
                listOfShapes.add(ShapesFactory.createShape("Square", origin, list));
                System.out.println("Shape added successfully");
                break;
            case 3:
                System.out.println("Enter origin x coordinate");
                xCoordinate=sc.nextInt();
                System.out.println("Enter origin y coordinate");
                yCoordinate=sc.nextInt();
                origin = new Point(xCoordinate, yCoordinate);
                System.out.println("Enter length of triangle");
                length=sc.nextInt();
                if(!operation.checkCoordinates(xCoordinate+length, yCoordinate+length)) {
                    System.out.println("coordinates are wrong");
                    System.exit(0);
                }
                list.add(3,length);
                listOfShapes.add(ShapesFactory.createShape("Triangle", origin, list));
                System.out.println("Shape added successfully");
                break;
            case 4:
                System.out.println("Enter center x coordinate");
                xCoordinate=sc.nextInt();
                System.out.println("Enter center y coordinate");
                yCoordinate=sc.nextInt();
                origin = new Point(xCoordinate, yCoordinate);
                System.out.println("Enter radius of circle");
                radius=sc.nextInt();
                if(!operation.checkCoordinates(xCoordinate+radius, yCoordinate+radius)) {
                    System.out.println("coordinates are wrong");
                    System.exit(0);
                }
                list.add(4,radius);
                listOfShapes.add(ShapesFactory.createShape("Circle", origin, list));
                System.out.println("Shape added successfully");
                break;
            }
            break;
        case 2:
            operation.displayShapes(listOfShapes);
            System.out.println("Enter index of list to remove");
            int index = sc.nextInt();
            listOfShapes.remove(index);
            System.out.println("Shape removed successfully");
            break;
        case 3:
            System.out.println("Enter shape type to remove");
            String shapeType = string.next();
            for(int i=0;i<listOfShapes.size();i++) { 
                if(listOfShapes.get(i).getShapeType().equals(shapeType)) {
                    listOfShapes.remove(i);
                }
            }
            System.out.println("Shapes removed successfully");
            break;
        case 4:
            operation.displayShapes(listOfShapes);
            break;
        case 5:
            System.out.println("1. Sort using area");
            System.out.println("2. Sort using perimeter");
            System.out.println("3. Sort using timestamp");
            System.out.println("4. Sort using distance origin"); 
            int sortChoice = sc.nextInt();
            if(sortChoice == 1) {
                operation.sortUsingArea(listOfShapes);
                operation.displayShapes(listOfShapes);
            }
            else if(sortChoice == 2) {
                operation.sortUsingPerimeter(listOfShapes);
                operation.displayShapes(listOfShapes);
            }
            else if(sortChoice == 3) {
                operation.sortUsingTimestamp(listOfShapes);
                operation.displayShapes(listOfShapes);
            }
        }
    }
}
