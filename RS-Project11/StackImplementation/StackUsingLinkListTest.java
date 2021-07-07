package stackAndQueueImplementation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackUsingLinkListTest {
    StackUsingLinkList list;

    @Before
    public void testStackUsingLinkList() {
        list = new StackUsingLinkList();
        list.pushInStack(4);
        list.pushInStack(7);
    }

    @Test
    public void testStackListPushValue5() {
        assertEquals(list.pushInStack(5), 5);
    }

    @Test
    public void testStackListPushValue9() {
        assertEquals(list.pushInStack(9), 9);
    }

    @Test
    public void testTopOfStackListValue7() {
        assertEquals(list.topOfStack(), 7);
    }

    @Test
    public void testStackListPushValue8() {
        assertNotEquals(list.pushInStack(8), 7);
    }

    @Test
    public void testTopOfStackListValue8() {
        assertNotEquals(list.topOfStack(), 8);
    }

    @Test
    public void testIsStackEmpty() {
        assertEquals(list.isStackEmpty(), false);
    }

    @Test
    public void testStackListPopValue7() {
        assertEquals(list.popFromStack(), 7);
    }

    @Test
    public void testStackListPopValue4() {
        assertEquals(list.popFromStack(), 7);
        assertEquals(list.popFromStack(), 4);
    }

    @Test
    public void testStackListPopValue() {
        assertEquals(list.popFromStack(), 7);
        assertEquals(list.popFromStack(), 4);
        assertEquals(list.popFromStack(), -1);
    }
}
