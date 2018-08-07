import priorityqueue.PriorityQueueImplementation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vishn_000
 */
public class PriorityQueueTest {
    PriorityQueueImplementation queue;
    @Before
    public void test(){
    queue=new PriorityQueueImplementation();
        queue.addToQueue(10,"Simran");
        queue.addToQueue(30,"Kush");
        queue.addToQueue(5,"Shyam");
    }
    @Test
    public void testPriorityQueueAddValue50() {
        assertEquals(queue.addToQueue(50,"Somi"),"Somi");
    }
 /*   @Test
    public void testPriorityQueueAddValue100() {
        assertEquals(queue.addToQueue(100,"Khushboo"),"Khushboo");
    }
    @Test
    public void testPriorityQueueAddValue20() {
        assertEquals(queue.addToQueue(20,"Ram"),"Kush");
    }
    @Test
    public void testPriorityQueueRemoveValue30() {
        assertEquals(queue.deleteFromQueue(),"Kush");
    }
    @Test
    public void testPriorityQueueRemoveValue50() {
        assertEquals(queue.addToQueue(50,"Somi"),"Somi");
        assertEquals(queue.deleteFromQueue(),"Somi");
    }
    @Test
    public void testPriorityQueueRemoveValue100() {
        assertEquals(queue.addToQueue(50,"Somi"),"Somi");
        assertEquals(queue.addToQueue(100,"Khushboo"),"Khushboo");
        assertEquals(queue.deleteFromQueue(),"Khushboo");
    }
    @Test
    public void testPriorityQueuePeekValueKush() {
        assertEquals(queue.peek(),"Kush");
    }*/
    @Test
    public void testPriorityQueuePeekValueSomi() {
        assertEquals(queue.addToQueue(50,"Somi"),"Somi");
        assertEquals(queue.peek(),"Kush");
    }
    @Test
    public void testPriorityQueueIsEmpty() {
        assertEquals(queue.isQueueEmpty(),false);
    }
}
