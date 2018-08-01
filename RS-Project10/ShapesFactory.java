package graphics;

import java.util.*;

/**
 * creates object of class Shapes
 */
public class ShapesFactory {
    
    /**
     * create shapes of various types
     * @param shape type, point coordinates as origin, list of parameters
     * @return shape
     */
    public static Shape createShape(String shapeType, Point point, ArrayList<Integer> list) {
        Shape shape = null;
        if (Shape.ShapesType.Rectangle.toString().equals(shapeType)) {
            shape = new Rectangle(point, list.get(0), list.get(1));
        } else if (Shape.ShapesType.Square.toString().equals(shapeType)) {
            shape = new Square(point, list.get(0));
        } else if (Shape.ShapesType.Circle.toString().equals(shapeType)) {
            shape = new Circle(point, list.get(0));
        } else {
            System.out.println("Shape is inavlid");
            System.exit(0);
        }
        return shape;
    }

    /**
     * create shapes of triangle types
     * @param shape type, point coordinates as origin and point opposite to base , list of parameters
     * @return shape
     */
    public static Shape createTriangle
        (String shapeType, Point point, Point pointOppositeToBase, ArrayList<Integer> list) {
        Shape shape = null;
        if (Shape.ShapesType.Triangle.toString().equals(shapeType)) {
            shape = new Triangle(point, pointOppositeToBase, list.get(0));
        } else {
            System.out.println("Shape is inavlid");
            System.exit(0);
        }
        return shape;
    }
}
