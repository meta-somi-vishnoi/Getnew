package Graphics;

import java.util.*;
import java.sql.*;

public interface Shapes {
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

class Rectangle implements Shapes {
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
        int xCoordinateOfLocation = location.getXCoordinate();
        int yCoordinateOfLocation = location.getYCoordinate();
        int leftLimit = origin.getXCoordinate();
        int rightLimit = origin.getXCoordinate() + length;
        int bottomLimit = origin.getYCoordinate();
        int topLimit = origin.getYCoordinate() + breadth;
        if (xCoordinateOfLocation > leftLimit && xCoordinateOfLocation < rightLimit && 
            yCoordinateOfLocation > bottomLimit && yCoordinateOfLocation < topLimit) {
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

class Square implements Shapes {
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
        int xCoordinateOfLocation = location.getXCoordinate();
        int yCoordinateOfLocation = location.getYCoordinate();
        int leftLimit = origin.getXCoordinate();
        int rightLimit = origin.getXCoordinate() + length;
        int bottomLimit = origin.getYCoordinate();
        int topLimit = origin.getYCoordinate() + length;
        if (xCoordinateOfLocation > leftLimit && xCoordinateOfLocation < rightLimit && 
            yCoordinateOfLocation > bottomLimit && yCoordinateOfLocation < topLimit) {
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

class Triangle implements Shapes {
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
            (origin.getXCoordinate() + length)),2)) + (Math.pow(pointOppositeToBase.getYCoordinate() - 
            origin.getYCoordinate(), 2)));
        return (length + firstSideLength + otherSideLength);
    }

    public Point getOrigin() {
        return origin;
    }

    public boolean isPointEnclosed(Point location) {
        int xCoordinateOfLocation = location.getXCoordinate();
        int yCoordinateOfLocation = location.getYCoordinate();
        int firstPointXCoordinate = origin.getXCoordinate();
        int secondPointXCoordinate = origin.getXCoordinate() + length;
        int firstPointYCoordinate = origin.getYCoordinate();
        int secondPointYCoordinate = origin.getYCoordinate();
        int thirdPointXCoordinate = pointOppositeToBase.getXCoordinate();
        int thirdPointYCoordinate = pointOppositeToBase.getYCoordinate();
        int firstSideCompare = ((yCoordinateOfLocation - firstPointYCoordinate) / 
            (thirdPointYCoordinate - firstPointYCoordinate)) - ((xCoordinateOfLocation - firstPointXCoordinate) /
            (thirdPointXCoordinate-firstPointXCoordinate));
        int secondSideCompare = ((yCoordinateOfLocation - firstPointYCoordinate) / 
            (thirdPointYCoordinate - firstPointYCoordinate)) - ((xCoordinateOfLocation - secondPointXCoordinate) /  
            (thirdPointXCoordinate - secondPointXCoordinate));
        if(firstSideCompare < 0 && secondSideCompare < 0 && yCoordinateOfLocation > firstPointYCoordinate) {
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

class Circle implements Shapes {
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
        int xCenter = center.getXCoordinate();
        int yCenter = center.getYCoordinate();
        return center;
    }

    public boolean isPointEnclosed(Point location) {
        int xCoordinateOfLocation = location.getXCoordinate();
        int yCoordinateOfLocation = location.getYCoordinate();
        double distance = Math.sqrt((Math.pow((xCoordinateOfLocation - center.getXCoordinate()), 2))
                + (Math.pow((yCoordinateOfLocation - center.getYCoordinate()), 2)));
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
