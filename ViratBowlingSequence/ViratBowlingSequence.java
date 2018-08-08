package priorityqueue;

import java.util.ArrayList;

/**
 *
 * @author vishn_000
 */
public class ViratBowlingSequence {
    PriorityQueueImplementation operation = new PriorityQueueImplementation();
    public ArrayList<PriorityQueue> queue = new ArrayList<PriorityQueue>();

    public void addPlayer(Integer bowls, String name) {
        operation.addToQueue(queue, bowls, name);
    }

    public String playBowls(Integer totalBowls) {
        StringBuilder order = new StringBuilder();
        for (int i = 0; i < totalBowls; i++) {
            if (operation.isQueueEmpty(queue)) {
                throw new AssertionError("not enough bowlers");
            }
            queue.get(0).setPriority();
            order.append(operation.peek(queue).getData());
            if (operation.peek(queue).getPriority() == 0) {
                operation.deleteFromQueue(queue);
            }
            if (i != totalBowls - 1) {
                order.append("->");
            }
            operation.maxHeapify(queue);
        }
        return order.toString();
    }
}
