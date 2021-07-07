package nestedlist;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class HeadTailInListTest {
    ArrayList<Object> nestedList = new ArrayList<Object>();
    HeadTailNestedList listTraversal = new HeadTailNestedList();

    @Before
    public void test() {

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        list.add(new ArrayList<Integer>(Arrays.asList(300, 500, 177)));
        list.add(new ArrayList<Integer>(Arrays.asList(208, 48)));
        listTraversal.createNestedList(nestedList, new ArrayList<Integer>(Arrays.asList(1000, 1100)));
        listTraversal.createNestedList(nestedList, list);
        listTraversal.createNestedList(nestedList, 20);
        listTraversal.createNestedList(nestedList, 50);
    }

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabled() {
        assertEquals(listTraversal.getValue("TTTTTH", nestedList), 2);
    }

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabledForTail() {
        assertEquals(listTraversal.getValue("TH", nestedList), 2);
    }

    @Test(expected = AssertionError.class)
    public void testAssertionsEnabledFalse() {
        assertEquals(listTraversal.getValue("HTH", nestedList), 6);
    }

    @Test
    public void testGetValueHead50() {
        int result = (Integer) listTraversal.getValue("TTTH", nestedList);
        assertEquals(result, 50);
    }

    @Test
    public void testGetValueHead1000() {
        int result = (Integer) listTraversal.getValue("HH", nestedList);
        assertEquals(result, 1000);
    }

    @Test
    public void testGetValueHeadList() {
        Object result = listTraversal.getValue("TT", nestedList);
        assertEquals(result, new ArrayList<Integer>(Arrays.asList(20, 50)));
    }
}
