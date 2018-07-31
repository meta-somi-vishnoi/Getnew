package Graphics;
import java.util.*;

public class ShapesOperations {
    
    public boolean checkCoordinates(int xCoordinate, int yCoordinate) {
        if(xCoordinate>=0 && xCoordinate<=Shapes.XMAX && yCoordinate>=0 && yCoordinate<=Shapes.YMAX) {
            return true;
        }
        return false;
    }
    public void displayShapes(ArrayList<Shapes> listOfShapes) {
        for(int i=0;i<listOfShapes.size();i++) {
            System.out.print("Index: " + i);
            listOfShapes.get(i).getInformation();
        }
    }
    public void sortUsingArea(ArrayList<Shapes> listOfShapes) {
        for(int i=0;i<listOfShapes.size()-1;i++) {
            for(int j=0;j<listOfShapes.size()-i-1;j++) {
                if(listOfShapes.get(j).getArea()>listOfShapes.get(j+1).getArea()) {
                    Shapes shape=listOfShapes.get(j);
                    listOfShapes.add(j,listOfShapes.get(j+1));
                    listOfShapes.add(j+1,shape);
                }
            }
        }
    }
    public void sortUsingPerimeter(ArrayList<Shapes> listOfShapes) {
        for(int i=0;i<listOfShapes.size()-1;i++) {
            for(int j=0;j<listOfShapes.size()-i-1;j++) {
                if(listOfShapes.get(j).getPerimeter()>listOfShapes.get(j+1).getPerimeter()) {
                    Shapes shape=listOfShapes.get(j);
                    listOfShapes.add(j,listOfShapes.get(j+1));
                    listOfShapes.add(j+1,shape);
                }
            }
        }
    }
    public void sortUsingTimestamp(ArrayList<Shapes> listOfShapes) {
        for(int i=0;i<listOfShapes.size()-1;i++) {
            for(int j=0;j<listOfShapes.size()-i-1;j++) {
                timestamp firstShape=listOfShapes.get(j).getTimestamp();
                Date secondShape=listOfShapes.get(j).getTimestamp();
                if(listOfShapes.get(j).getTimestamp()>listOfShapes.get(j+1).getTimestamp()) {
                    Shapes shape=listOfShapes.get(j);
                    listOfShapes.add(j,listOfShapes.get(j+1));
                    listOfShapes.add(j+1,shape);
                }
            }
        }
    }
}
