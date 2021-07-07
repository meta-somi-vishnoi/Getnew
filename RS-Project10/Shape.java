package graphics;

import java.util.*;
import java.sql.*;

public interface Shape {
    enum ShapesType {
        Rectangle, Triangle, Square, Circle
    };

    public final int XMAX = 1080;
    public final int YMAX = 720;

    public double getArea();

    public double getPerimeter();

    public Point getOrigin();

    public boolean isPointEnclosed(Point location);

    public void getInformation();

    public String getShapeType();

    public Timestamp getTimestamp();
}

class Rectangle implements Shape {
    private String shapeType = "Rectangle";
    private Point origin;
    private Timestamp timestamp;
    private int length;
    private int breadth;

    Rectangle(Point origin, int length, int breadth) {
        this.origin = origin;
        this.length = length;
        this.breadth = breadth;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public double getArea() {
        return length * breadth;
    }

    public double getPerimeter() {
        return (2 * (length + breadth));
    }

    public Point getOrigin() {
        return origin;
    }

    public boolean isPointEnclosed(Point location) {
        if (location.getXCoordinate() > origin.getXCoordinate() && location.getXCoordinate() < origin.getXCoordinate() + 
            length && location.getYCoordinate() > origin.getYCoordinate() && location.getYCoordinate() < 
            origin.getYCoordinate() + breadth) {
            return true;
        } else {
            return false;
        }
    }

    public void getInformation() {
        System.out.println("Shape Type:" + shapeType + "\t Origin:(" + origin.getXCoordinate() + "," + 
            origin.getXCoordinate() + ") \t length:" + length + "\t breadth:" + breadth);
    }

    public String getShapeType() {
        return shapeType;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}

class Square implements Shape {
    private String shapeType = "Square";
    private Point origin;
    private int length;
    private Timestamp timestamp;

    Square(Point origin, int length) {
        this.origin = origin;
        this.length = length;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public double getArea() {
        return length * length;
    }

    public double getPerimeter() {
        return (4 * (length));
    }

    public Point getOrigin() {
        return origin;
    }

    public boolean isPointEnclosed(Point location) {
        if (location.getXCoordinate() > origin.getXCoordinate() && location.getXCoordinate() < origin.getXCoordinate() + 
            length && location.getYCoordinate() > origin.getYCoordinate() && location.getYCoordinate() < 
            origin.getYCoordinate() + length) {
            return true;
        } else {
            return false;
        }
    }

    public void getInformation() {
        System.out.println("Shape Type:" + shapeType + "\t Origin:(" + origin.getXCoordinate() + "," +
            origin.getXCoordinate() + ") \t length:" + length);
    }

    public String getShapeType() {
        return shapeType;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}

class Triangle implements Shape {
    private String shapeType = "Triangle";
    private Point origin;
    private Point pointOppositeToBase;
    private int length;
    private Timestamp timestamp;

    Triangle(Point origin, Point pointOppositeToBase, int length) {
        this.origin = origin;
        this.pointOppositeToBase = pointOppositeToBase;
        this.length = length;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public double getArea() {
        return (1 / 2) * (length) * (pointOppositeToBase.getYCoordinate() - origin.getYCoordinate());
    }

    public double getPerimeter() {
        double firstSideLength = Math.sqrt((Math.pow((pointOppositeToBase.getXCoordinate() - 
            origin.getXCoordinate()), 2)) + (Math.pow(pointOppositeToBase.getYCoordinate() - 
            origin.getYCoordinate(), 2)));
        double otherSideLength = Math.sqrt((Math.pow((pointOppositeToBase.getXCoordinate() - 
            (origin.getXCoordinate() + length)), 2)) + (Math.pow(pointOppositeToBase.getYCoordinate() - 
            origin.getYCoordinate(), 2)));
        return (length + firstSideLength + otherSideLength);
    }

    public Point getOrigin() {
        return origin;
    }

    public boolean isPointEnclosed(Point location) {
        double firstSideCompare = ((location.getYCoordinate() - origin.getYCoordinate()) / 
            (pointOppositeToBase.getYCoordinate() - origin.getYCoordinate())) - ((location.getXCoordinate() - 
            origin.getXCoordinate()) / (pointOppositeToBase.getXCoordinate() - origin.getXCoordinate()));
        double secondSideCompare = ((location.getYCoordinate() - origin.getYCoordinate()) / 
            (pointOppositeToBase.getYCoordinate() - origin.getYCoordinate())) - ((location.getXCoordinate() - 
            origin.getXCoordinate() + length) / (pointOppositeToBase.getXCoordinate() - origin.getXCoordinate() + length));
        if (firstSideCompare < 0 && secondSideCompare < 0 && location.getYCoordinate() > origin.getYCoordinate()) {
            return true;
        }
        return false;
    }

    public void getInformation() {
        System.out.println("Shape Type:" + shapeType + "\t Origin:(" + origin.getXCoordinate() + "," + 
            origin.getXCoordinate() + ") \t length:" + length);
    }

    public String getShapeType() {
        return shapeType;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}

class Circle implements Shape {
    private String shapeType = "Circle";
    private Point center;
    private int radius;
    private Timestamp timestamp;

    Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public double getArea() {
        return (Math.PI * radius * radius);
    }

    public double getPerimeter() {
        return (Math.PI * 2 * radius);
    }

    public Point getOrigin() {
        double quadraticEquationAValue = Math.pow(center.getXCoordinate(), 2) + Math.pow(center.getYCoordinate(), 2);
        double quadraticEquationBValue = (-2) * (Math.pow(center.getXCoordinate(), 3)) + (-2) * 
            (Math.pow(center.getYCoordinate(), 2)) * center.getXCoordinate();
        double quadraticEquationCValue = Math.pow(center.getXCoordinate(), 4) + (2) * (Math.pow(center.getYCoordinate(), 2)) * 
            (Math.pow(center.getXCoordinate(), 2)) - (Math.pow(radius, 2)) * (Math.pow(center.getXCoordinate(), 2));
        double firstXSolution = ((-1 * quadraticEquationBValue) + (Math.sqrt((Math.pow(quadraticEquationBValue, 2)) -
            (4 * quadraticEquationAValue * quadraticEquationCValue))) /
            (2 * quadraticEquationAValue));
        double secondXSolution = ((-1 * quadraticEquationBValue) - (Math.sqrt((Math.pow(quadraticEquationBValue, 2)) -
            (4 * quadraticEquationAValue * quadraticEquationCValue))) /
            (2 * quadraticEquationAValue));
        double xSolution, ySolution;
        if (firstXSolution < secondXSolution && firstXSolution > 0) {
            xSolution = firstXSolution;
        } else {
            xSolution = secondXSolution;
        }
        ySolution = center.getYCoordinate() * xSolution / center.getXCoordinate();
        Point origin = new Point(xSolution, ySolution);
        return origin;
    }

    public boolean isPointEnclosed(Point location) {
        double distance = Math.sqrt((Math.pow((location.getXCoordinate() - center.getXCoordinate()), 2)) +
            (Math.pow((location.getYCoordinate() - center.getYCoordinate()), 2)));
        if (distance < radius) {
            return true;
        } else {
            return false;
        }
    }

    public void getInformation() {
        System.out.println("Shape Type:" + shapeType + "\t Center:(" + center.getXCoordinate() + "," + 
            center.getXCoordinate() + ") \t radius:" + radius);
    }

    public String getShapeType() {
        return shapeType;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
