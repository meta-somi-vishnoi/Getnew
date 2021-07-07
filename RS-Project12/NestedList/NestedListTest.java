package nestedlist;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NestedListTest {
    ArrayList<Object> nestedList = new ArrayList<Object>();

    @Before
    public void test() {
        TraverseNestedList listTraversal = new TraverseNestedList();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        list.add(new ArrayList<Integer>(Arrays.asList(300, 500, 177)));
        list.add(new ArrayList<Integer>(Arrays.asList(208, 48)));
        listTraversal.createNestedList(nestedList, new ArrayList<Integer>(Arrays.asList(1000, 1100)));
        listTraversal.createNestedList(nestedList, list);
        listTraversal.createNestedList(nestedList, 20);
    }

    @Test
    public void testSumOfList() {
        TraverseNestedList listTraversal = new TraverseNestedList();
        int sum = listTraversal.sumOfList(nestedList);
        assertEquals(3353, sum);
    }

    @Test
    public void testGetMaximumValue() {
        TraverseNestedList listTraversal = new TraverseNestedList();
        int maximum = listTraversal.getMaximumValue(nestedList);
        assertEquals(1100, maximum);
    }

    @Test
    public void testGetMaximumValueFalse() {
        TraverseNestedList listTraversal = new TraverseNestedList();
        int maximum = listTraversal.getMaximumValue(nestedList);
        assertNotEquals(100, maximum);
    }

    @Test
    public void testIsValuePresent208() {
        TraverseNestedList listTraversal = new TraverseNestedList();
        assertTrue(listTraversal.isValuePresent(nestedList, 208));
    }
    
    @Test
    public void testIsValuePresent1000() {
        TraverseNestedList listTraversal = new TraverseNestedList();
        assertTrue(listTraversal.isValuePresent(nestedList, 1000));
    }
}