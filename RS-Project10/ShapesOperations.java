package Graphics;

import java.util.*;
import java.sql.*;

public class ShapesOperations {

    /**
     * checks point is within defined range
     * 
     * @param x
     *            coordinate of point, y coordinate of point
     */
    public boolean checkCoordinates(int xCoordinate, int yCoordinate) {
        if (xCoordinate >= 0 && xCoordinate <= Shapes.XMAX && yCoordinate >= 0 && 
            yCoordinate <= Shapes.YMAX) {
            return true;
        }
        return false;
    }

    /**
     * display shapes of various types
     * @param list of shapes
     */
    public void displayShapes(ArrayList<Shapes> listOfShapes) {
        for (int i = 0; i < listOfShapes.size(); i++) {
            System.out.print("Index: " + (i + 1) + "\t");
            listOfShapes.get(i).getInformation();
        }
    }

    /**
     * sorts shapes of various types using area
     * @param list of shapes
     */
    public void sortUsingArea(ArrayList<Shapes> listOfShapes) {
        ArrayList<Shapes> listOfSortedShapes = new ArrayList<Shapes>(listOfShapes);
        for (int i = 0; i < (listOfSortedShapes.size() - 1); i++) {
            for (int j = 0; j < (listOfSortedShapes.size() - i - 1); j++) {
                if (listOfSortedShapes.get(j).getArea() > listOfSortedShapes.get(j + 1).getArea()) {
                    Shapes shape = listOfSortedShapes.get(j);
                    listOfSortedShapes.set(j, listOfSortedShapes.get(j + 1));
                    listOfSortedShapes.set(j + 1, shape);
                }
            }
        }
        displayShapes(listOfSortedShapes);
    }

    /**
     * sorts shapes of various types using perimeter
     * @param list of shapes
     */
    public void sortUsingPerimeter(ArrayList<Shapes> listOfShapes) {
        ArrayList<Shapes> listOfSortedShapes = new ArrayList<Shapes>(listOfShapes);
        for (int i = 0; i < listOfSortedShapes.size() - 1; i++) {
            for (int j = 0; j < listOfSortedShapes.size() - i - 1; j++) {
                if (listOfSortedShapes.get(j).getPerimeter() > listOfSortedShapes.get(j + 1).getPerimeter()) {
                    Shapes shape = listOfSortedShapes.get(j);
                    listOfSortedShapes.set(j, listOfSortedShapes.get(j + 1));
                    listOfSortedShapes.set(j + 1, shape);
                }
            }
        }
    }

    /**
     * sorts shapes of various types using timestamp
     * @param list of shapes
     */
    public void sortUsingTimestamp(ArrayList<Shapes> listOfShapes) {
        ArrayList<Shapes> listOfSortedShapes = new ArrayList<Shapes>(listOfShapes);
        for (int i = 0; i < listOfSortedShapes.size() - 1; i++) {
            for (int j = 0; j < listOfSortedShapes.size() - i - 1; j++) {
                Timestamp firstShapeTimestamp = listOfSortedShapes.get(j).getTimestamp();
                Timestamp secondShapeTimestamp = listOfSortedShapes.get(j).getTimestamp();
                if (firstShapeTimestamp.after(secondShapeTimestamp)) {
                    Shapes shape = listOfSortedShapes.get(j);
                    listOfSortedShapes.set(j, listOfSortedShapes.get(j + 1));
                    listOfSortedShapes.set(j + 1, shape);
                }
            }
        }
    }

    /**
     * sorts shapes of various types using distance from origin
     * @param list of shapes
     */
    public void sortUsingOriginDistance(ArrayList<Shapes> listOfShapes) {
        ArrayList<Shapes> listOfSortedShapes = new ArrayList<Shapes>(listOfShapes);
        for (int i = 0; i < listOfSortedShapes.size() - 1; i++) {
            for (int j = 0; j < listOfSortedShapes.size() - i - 1; j++) {
                Point firstShapeOrigin = listOfSortedShapes.get(j).getOrigin();
                Point secondShapeOrigin = listOfSortedShapes.get(j + 1).getOrigin();
                double xCoordinateFirstShape = firstShapeOrigin.getXCoordinate();
                double yCoordinateFirstShape = firstShapeOrigin.getYCoordinate();
                double xCoordinateSecondShape = secondShapeOrigin.getXCoordinate();
                double yCoordinateSecondShape = secondShapeOrigin.getYCoordinate();
                double distanceOfFirstShape = Math.sqrt(Math.pow(xCoordinateFirstShape, 2) + 
                    Math.pow(yCoordinateFirstShape, 2));
                double distanceOfSecondShape = Math.sqrt(Math.pow(xCoordinateSecondShape, 2) +
                    Math.pow(yCoordinateSecondShape, 2));
                if (distanceOfFirstShape > distanceOfSecondShape) {
                    Shapes shape = listOfSortedShapes.get(j);
                    listOfSortedShapes.set(j, listOfSortedShapes.get(j + 1));
                    listOfSortedShapes.set(j + 1, shape);
                }
            }
        }
    }

    /**
     * shapes of various types enclosing a given point
     * @param list of shapes, point
     * @return list of shapes enclosing given point
     */
    public ArrayList<Shapes> getShapesEnclosingPoint(ArrayList<Shapes> listOfShapes, Point point) {
        ArrayList<Shapes> listOfShapesEnclosingPoint = new ArrayList<Shapes>();
        for (int i = 0; i < listOfShapes.size(); i++) {
            if (listOfShapes.get(i).isPointEnclosed(point)) {
                listOfShapesEnclosingPoint.add(listOfShapes.get(i));
            }
        }
        return listOfShapesEnclosingPoint;
    }

    /**
     * shapes of various types above a given shape
     * @param list of shapes, index of shape
     * @return list of shapes
     */
    public ArrayList<Shapes> getAboveShapes(ArrayList<Shapes> listOfShapes, int index) {
        ArrayList<Shapes> listOfShapesAbove = new ArrayList<Shapes>();
        for (int i = 0; i < listOfShapes.size(); i++) {
            if (listOfShapes.get(i).getTimestamp().after(listOfShapes.get(index).getTimestamp())) {
                listOfShapesAbove.add(listOfShapes.get(i));
            }
        }
        return listOfShapesAbove;
    }
}
