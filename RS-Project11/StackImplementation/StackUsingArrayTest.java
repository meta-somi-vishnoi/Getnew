package stackImplementation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackUsingArrayTest {
    StackUsingArray stack;

    @Before
    public void testStackArray() {
        stack = new StackUsingArray();
        stack.pushInStack(4);
        stack.pushInStack(7);
    }

    @Test
    public void testStackArrayPushValue5() {
        assertEquals(stack.pushInStack(5), 5);
    }

    @Test
    public void testStackArrayPushValue9() {
        assertEquals(stack.pushInStack(9), 9);
    }

    @Test
    public void testTopOfStackArrayValue7() {
        assertEquals(stack.topOfStack(), 7);
    }

    @Test
    public void testIsStackFull() {
        assertEquals(stack.isStackFull(), false);
    }

    @Test
    public void testStackArrayPushValue8() {
        assertNotEquals(stack.pushInStack(8), 7);
    }

    @Test
    public void testStackArrayIsFull() {
        assertEquals(stack.pushInStack(5), 5);
        assertEquals(stack.pushInStack(3), 3);
        assertEquals(stack.pushInStack(4), 4);
        assertEquals(stack.pushInStack(5), 5);
        assertEquals(stack.pushInStack(9), 9);
        assertEquals(stack.isStackFull(), false);
        assertEquals(stack.pushInStack(51), 51);
        assertEquals(stack.pushInStack(13), 13);
        assertEquals(stack.pushInStack(33), 33);
        assertEquals(stack.isStackFull(), true);
    }
    
    @Test
    public void testTopOfStackArrayValue8() {
        assertNotEquals(stack.topOfStack(), 8);
    }

    @Test
    public void testIsStackEmpty() {
        assertEquals(stack.isStackEmpty(), false);
    }

    @Test
    public void testStackArrayPopValue7() {
        assertEquals(stack.popFromStack(), 7);
    }

    @Test
    public void testStackArrayPopValue4() {
        assertEquals(stack.popFromStack(), 7);
        assertEquals(stack.popFromStack(), 4);
    }

    @Test
    public void testStackArrayPopValue() {
        assertEquals(stack.popFromStack(), 7);
        assertEquals(stack.popFromStack(), 4);
        assertEquals(stack.popFromStack(), -1);
    }
}
