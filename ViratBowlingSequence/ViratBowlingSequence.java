package priorityqueue;
/**
 *
 * @author vishn_000
 */
public class ViratBowlingSequence {
    PriorityQueueImplementation queue= new PriorityQueueImplementation();
    public void addPlayer(Integer bowls, String name) {
        queue.addToQueue(bowls,name);
    }
    public StringBuilder playBowls(Integer totalBowls) {
        StringBuilder order = new StringBuilder();
        for(int i=0;i<totalBowls;i++) {
            if(queue.isQueueEmpty()) {
                throw new AssertionError("not enough bowlers");
            }
            queue.peek().setPriority(queue.peek().getPriority()-1);
            order.append(queue.peek().getData());
            if(queue.peek().getPriority()==0) {
                queue.deleteFromQueue();
            }
            order.append("->");
            queue.maxHeapify();
        }
        return order;
    }
}
