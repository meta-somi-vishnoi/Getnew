package queueImplementation;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class QueueUsingArrayTest {
    QueueUsingArray queue;

    @Before
    public void testStackArray() {
        queue = new QueueUsingArray();
        queue.addItemToQueue(4);
        queue.addItemToQueue(7);
        queue.addItemToQueue(8);
    }

    @Test
    public void testQueueAddItem3() {
        assertEquals((int)queue.addItemToQueue(3), 3);
    }

    @Test
    public void testIsQueueEmptyFalse() {
        assertEquals(queue.isQueueEmpty(), false);
    }

    @Test
    public void testQueueAddItem9() {
        assertEquals((int)queue.addItemToQueue(9), 9);
    }

    @Test
    public void testQueueAddItem10() {
        assertNotEquals((int)queue.addItemToQueue(10), 17);
    }

    @Test
    public void testIsQueueFullFalse() {
        assertEquals(queue.isQueueFull(), false);
    }

    @Test
    public void testQueueDeleteItem4() {
        assertEquals((int)queue.deleteItemFromQueue(), 4);
    }

    @Test
    public void testQueueDeleteItem7() {
        assertEquals((int)queue.deleteItemFromQueue(), 4);
        assertEquals((int)queue.deleteItemFromQueue(), 7);
    }

    @Test
    public void testIsQueueEmptyTrue() {
        assertEquals((int)queue.deleteItemFromQueue(), 4);
        assertEquals((int)queue.deleteItemFromQueue(), 7);
        assertEquals(queue.isQueueEmpty(), false);
        assertEquals((int)queue.deleteItemFromQueue(), 8);
        assertEquals(queue.isQueueEmpty(), true);
    }

    @Test
    public void testIsQueueFullTrue() {
        assertEquals((int)queue.addItemToQueue(9), 9);
        assertEquals((int)queue.addItemToQueue(9), 9);
        assertEquals(queue.isQueueFull(), true);
    }
}
