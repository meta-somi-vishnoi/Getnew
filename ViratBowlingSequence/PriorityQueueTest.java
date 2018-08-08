package priorityqueue;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
    PriorityQueueImplementation operation;
    public ArrayList<PriorityQueue> queue = new ArrayList<PriorityQueue>();

    @Before
    public void test() {
        operation = new PriorityQueueImplementation();
        operation.addToQueue(queue, 10, "Simran");
        operation.addToQueue(queue, 30, "Kush");
        operation.addToQueue(queue, 5, "Shyam");
    }

    @Test
    public void testPriorityQueueAddValue50() {
        assertEquals(operation.addToQueue(queue, 50, "Somi"), "Somi");
    }

    @Test
    public void testPriorityQueueAddValue100() {
        assertEquals(operation.addToQueue(queue, 100, "Khushboo"), "Khushboo");
    }

    @Test
    public void testPriorityQueueAddValue20() {
        assertEquals(operation.addToQueue(queue, 20, "Ram"), "Kush");
    }

    @Test
    public void testPriorityQueueRemoveValue30() {
        assertEquals(operation.deleteFromQueue(queue), "Kush");
    }

    @Test
    public void testPriorityQueueRemoveValue50() {
        assertEquals(operation.addToQueue(queue, 50, "Somi"), "Somi");
        assertEquals(operation.deleteFromQueue(queue), "Somi");
    }

    @Test
    public void testPriorityQueuePeekValueKush() {
        assertEquals(operation.peek(queue).getData(), "Kush");
    }

    @Test
    public void testPriorityQueuePeekValueSomi() {
        assertEquals(operation.addToQueue(queue, 50, "Somi"), "Somi");
        assertEquals(operation.peek(queue).getData(), "Somi");
    }

    @Test
    public void testPriorityQueueIsEmpty() {
        assertEquals(operation.isQueueEmpty(queue), false);
    }
}
