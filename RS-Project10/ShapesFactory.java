package Graphics;
import java.util.*;

public class ShapesFactory {
    public static Shapes createShape(String shapeType, Point point, ArrayList<Integer> list) {
        Shapes shape = null;
        if(Shapes.ShapesType.Rectangle.equals(shapeType)) {
            shape=new Rectangle(point, list.get(0), list.get(1));
        }
        else if(Shapes.ShapesType.Square.equals(shapeType)) {
            shape=new Square(point, list.get(2));
        }
        else if(Shapes.ShapesType.Triangle.equals(shapeType)) {
            shape=new Triangle(point, list.get(3));
        }
        else if(Shapes.ShapesType.Circle.equals(shapeType)) {
            shape=new Circle(point, list.get(4));
        }
        else {
            System.out.println("Shape is inavlid");
            System.exit(0);
        }
        return shape;
    }
}
