package javamysqlconnectivity;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.ArrayList;

import org.junit.Test;

public class JDBCTest {

    QueriesExecution database = new QueriesExecution();

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabled() {
        database.selectQuery(50);
    }
    
    @Test
    public void testSelectQuery() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<ResultSetSelectQuery> list = database.selectQuery(4);
        ArrayList<ResultSetSelectQuery> actualList = new ArrayList<ResultSetSelectQuery>();
        actualList.add(new ResultSetSelectQuery(5, formatter.parse("2018-06-10"), 4000));
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i).getOrderId(), actualList.get(i).getOrderId());
            assertEquals(list.get(i).getOrderDate(), actualList.get(i).getOrderDate());
            assertEquals(list.get(i).getTotalPrice(), actualList.get(i).getTotalPrice());
        }
    }

    @Test
    public void testInsertQuery() {
        ArrayList<Node> listOfData = new ArrayList<Node>();
        listOfData.add(new Node(1, "image1insert.jpg"));
        listOfData.add(new Node(2, "image2insert.jpg"));
        listOfData.add(new Node(3, "image3insert.jpg"));
        listOfData.add(new Node(1, "image11insert.jpg"));
        listOfData.add(new Node(5, "image5insert.jpg"));
        listOfData.add(new Node(3, "image33insert.jpg"));
        assertEquals(6, database.insertQuery(listOfData));
    }

    @Test
    public void testDeleteQuery() {
        assertEquals(18, database.deleteQuery());
    }

    @Test
    public void testDisplayQuery() {
        ArrayList<Node> expectedList = database.displayQuery();
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(new Node(3, "Electronic_Gadgets"));
        list.add(new Node(10, "Clothing"));
        list.add(new Node(2, "Footwear"));
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i).getId(), expectedList.get(i).getId());
            assertEquals(list.get(i).getName(), expectedList.get(i).getName());
        }
    }
}
