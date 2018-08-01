package graphics;

import java.util.*;

public class Screen {
    static Scanner sc = new Scanner(System.in);
    public Point getCoordinates() {
        Point origin;
        int xCoordinate, yCoordinate;
        System.out.println("Enter origin x coordinate");
        xCoordinate = sc.nextInt();
        System.out.println("Enter origin y coordinate");
        yCoordinate = sc.nextInt();
        origin = new Point(xCoordinate, yCoordinate);
        return origin;
    }
    /**
     * create rectangle object
     * @param list of shapes
     */
    public void addRectangle(ArrayList<Shape> listOfShapes, ShapesOperations operation) {
        int length, breadth;
        ArrayList<Integer> listOfParameters = new ArrayList<Integer>();
        Point origin = getCoordinates();
        System.out.println("Enter length of rectangle");
        length = sc.nextInt();
        System.out.println("Enter breadth of rectangle");
        breadth = sc.nextInt();
        if (!operation.checkCoordinates(origin.getXCoordinate() + length, origin.getYCoordinate() + breadth) && 
            !operation.checkCoordinates(origin.getXCoordinate(), origin.getYCoordinate())) {
            System.out.println("coordinates are wrong");
            System.exit(0);
        }
        listOfParameters.add(length);
        listOfParameters.add(breadth);
        listOfShapes.add(ShapesFactory.createShape("Rectangle", origin, listOfParameters));
    }

    /**
     * create square object
     * @param list of shapes
     */
    public void addSquare(ArrayList<Shape> listOfShapes, ShapesOperations operation) {
        int length;
        ArrayList<Integer> listOfParameters = new ArrayList<Integer>();
        Point origin = getCoordinates();
        System.out.println("Enter length of square");
        length = sc.nextInt();
        listOfParameters.add(length);
        if (!operation.checkCoordinates(origin.getXCoordinate() + length, origin.getYCoordinate() + length) && 
            !operation.checkCoordinates(origin.getXCoordinate(), origin.getYCoordinate())) {
            System.out.println("coordinates are wrong");
            System.exit(0);
        }
        listOfShapes.add(ShapesFactory.createShape("Square", origin, listOfParameters));
    }

    /**
     * create triangle object
     * @param list of shapes
     */
    public void addTriangle(ArrayList<Shape> listOfShapes, ShapesOperations operation) {
        int length;
        Point pointOppositeToBase;
        int pointXCoordinate, pointYCoordinate;
        ArrayList<Integer> listOfParameters = new ArrayList<Integer>();
        Point origin = getCoordinates();
        System.out.println("Enter point Opposite To Base x coordinate");
        pointXCoordinate = sc.nextInt();
        System.out.println("Enter point Opposite To Base y coordinate");
        pointYCoordinate = sc.nextInt();
        pointOppositeToBase = new Point(pointXCoordinate, pointYCoordinate);
        System.out.println("Enter length of triangle");
        length = sc.nextInt();
        listOfParameters.add(length);
        if (!operation.checkCoordinates(origin.getXCoordinate() + length, origin.getYCoordinate() + length) && 
            !operation.checkCoordinates(origin.getXCoordinate(), origin.getYCoordinate())) {
            System.out.println("coordinates are wrong");
            System.exit(0);
        }
        if (!operation.checkCoordinates(pointXCoordinate, pointYCoordinate)) {
            System.out.println("coordinates are wrong");
            System.exit(0);
        }
        listOfShapes.add(ShapesFactory.createTriangle("Triangle", origin, pointOppositeToBase, 
            listOfParameters));
    }

    /**
     * create circle objects
     * @param list of shapes
     */
    public void addCircle(ArrayList<Shape> listOfShapes, ShapesOperations operation) {
        int radius;
        ArrayList<Integer> listOfParameters = new ArrayList<Integer>();
        Point origin = getCoordinates();
        System.out.println("Enter radius of circle");
        radius = sc.nextInt();
        if (!operation.checkCoordinates(origin.getXCoordinate() + radius, origin.getYCoordinate() + radius) && 
            !operation.checkCoordinates(origin.getXCoordinate() - radius, origin.getYCoordinate() - radius)) {
            System.out.println("coordinates are wrong");
            System.exit(0);
        }
        listOfParameters.add(radius);
        listOfShapes.add(ShapesFactory.createShape("Circle", origin, listOfParameters));
    }

    public static void main(String[] args) {
        int choice;
        int option;
        Scanner string = new Scanner(System.in);
        Screen screen = new Screen();
        ArrayList<Shape> listOfShapes = new ArrayList<Shape>();
        ShapesOperations operation = new ShapesOperations();
        do {
            try {
                System.out.println("Graphics library");
                System.out.println("Choose option");
                System.out.println("Press 1 To add shapes to screen");
                System.out.println("Press 2 To delete shape from screen");
                System.out.println("Press 3 To delete particular shape type from screen");
                System.out.println("Press 4 To display list of shape on screen");
                System.out.println("Press 5 To sort shapes in ascending order");
                System.out.println("Press 6 To get shapes enclosing specific point");
                System.out.println("Press 7 To get all shapes above given shape");
                System.out.println("Press 8 To get origin of shape");
                option = sc.nextInt();
                switch (option) {
                case 1:
                    System.out.println("Press 1 To create Rectangle");
                    System.out.println("Press 2 To create Square");
                    System.out.println("Press 3 To create Triangle");
                    System.out.println("Press 4 To create Circle");
                    choice = sc.nextInt();
                    switch (choice) {
                    case 1:
                        screen.addRectangle(listOfShapes, operation);
                        System.out.println("Shape added successfully");
                        break;
                    case 2:
                        screen.addSquare(listOfShapes, operation);
                        System.out.println("Shape added successfully");
                        break;
                    case 3:
                        screen.addTriangle(listOfShapes, operation);
                        System.out.println("Shape added successfully");
                        break;
                    case 4:
                        screen.addCircle(listOfShapes, operation);
                        System.out.println("Shape added successfully");
                        break;
                    }
                    break;
                case 2:
                    operation.displayShapes(listOfShapes);
                    System.out.println("Enter index of shape to remove");
                    int index = sc.nextInt();
                    listOfShapes.remove(index - 1);
                    System.out.println("Shape removed successfully");
                    break;
                case 3:
                    System.out.println("Enter shape type to remove");
                    String shapeType = string.next();
                    for (int i = 0; i < listOfShapes.size(); i++) {
                        if (listOfShapes.get(i).getShapeType().equals(shapeType)) {
                            listOfShapes.remove(i);
                        }
                    }
                    System.out.println("Shapes removed successfully");
                    break;
                case 4:
                    operation.displayShapes(listOfShapes);
                    break;
                case 5:
                    System.out.println("Press 1 Sort using area");
                    System.out.println("Press 2 Sort using perimeter");
                    System.out.println("Press 3 Sort using timestamp");
                    System.out.println("Press 4 Sort using distance from origin");
                    int sortChoice = sc.nextInt();
                    if (sortChoice == 1) {
                        operation.sortUsingArea(listOfShapes);
                    } else if (sortChoice == 2) {
                        operation.sortUsingPerimeter(listOfShapes);
                    } else if (sortChoice == 3) {
                        operation.sortUsingTimestamp(listOfShapes);
                    } else if (sortChoice == 4) {
                        operation.sortUsingOriginDistance(listOfShapes);
                    } else {
                        System.out.println("Invalis operation");
                        System.exit(0);
                    }
                    break;
                case 6:
                    int xCoordinate,
                    yCoordinate;
                    System.out.println("Enter x coordinate of point");
                    xCoordinate = sc.nextInt();
                    System.out.println("Enter y coordinate of point");
                    yCoordinate = sc.nextInt();
                    if (!operation.checkCoordinates(xCoordinate, yCoordinate)) {
                        System.out.println("coordinates are wrong");
                        System.exit(0);
                    }
                    Point point = new Point(xCoordinate, yCoordinate);
                    ArrayList<Shape> listOfShapesEnclosingPoint;
                    listOfShapesEnclosingPoint = operation.getShapesEnclosingPoint(listOfShapes, point);
                    operation.displayShapes(listOfShapesEnclosingPoint);
                    break;
                case 7:
                    operation.displayShapes(listOfShapes);
                    System.out.println("Enter index of shape");
                    int indexOfList = sc.nextInt();
                    ArrayList<Shape> listOfShapesAbove;
                    listOfShapesAbove = operation.getAboveShapes(listOfShapes, indexOfList - 1);
                    operation.displayShapes(listOfShapesAbove);
                    break;
                case 8:
                    operation.displayShapes(listOfShapes);
                    System.out.println("Enter index of shape");
                    int indexList = sc.nextInt();
                    Point origin = listOfShapes.get((indexList-1)).getOrigin();
                    System.out.println("X coordinate is " + origin.getXCoordinate());
                    System.out.println("Y coordinate is " + origin.getYCoordinate());
                    break;
                default :
                    System.out.println("Invalid choice");
                    break;
                }
            } catch(Exception e) {
                System.out.println("Enter valid inputs");
            }
        } while (true);
    }
}
