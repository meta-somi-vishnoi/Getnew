package priorityqueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
    PriorityQueueImplementation queue;

    @Before
    public void test() {
        queue = new PriorityQueueImplementation();
        queue.addToQueue(10, "Simran");
        queue.addToQueue(30, "Kush");
        queue.addToQueue(5, "Shyam");
    }

    @Test
    public void testPriorityQueueAddValue50() {
        assertEquals(queue.addToQueue(50, "Somi"), "Somi");
    }

    @Test
    public void testPriorityQueueAddValue100() {
        assertEquals(queue.addToQueue(100, "Khushboo"), "Khushboo");
    }

    @Test
    public void testPriorityQueueAddValue20() {
        assertEquals(queue.addToQueue(20, "Ram"), "Kush");
    }

    @Test
    public void testPriorityQueueRemoveValue30() {
        assertEquals(queue.deleteFromQueue(), "Kush");
    }

    @Test
    public void testPriorityQueueRemoveValue50() {
        assertEquals(queue.addToQueue(50, "Somi"), "Somi");
        assertEquals(queue.deleteFromQueue(), "Somi");
    }

    @Test
    public void testPriorityQueuePeekValueKush() {
        assertEquals(queue.peek(), "Kush");
    }

    @Test
    public void testPriorityQueuePeekValueSomi() {
        assertEquals(queue.addToQueue(50, "Somi"), "Somi");
        assertEquals(queue.peek(), "Somi");
    }

    @Test
    public void testPriorityQueueIsEmpty() {
        assertEquals(queue.isQueueEmpty(), false);
    }
}
