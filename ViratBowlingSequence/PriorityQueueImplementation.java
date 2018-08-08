package priorityqueue;

import java.util.*;

/**
 *
 * @author vishn_000
 */
class PriorityQueue {
    private Integer priority;
    private String data;

    PriorityQueue(Integer priority, String data) {
        this.priority = priority;
        this.data = data;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority() {
        priority = priority - 1;
    }

    public String getData() {
        return data;
    }
}

public class PriorityQueueImplementation {
    public void swap(ArrayList<PriorityQueue> queue, Integer first, Integer second) {
        PriorityQueue temporary = queue.get(first);
        queue.set(first, queue.get(second));
        queue.set(second, temporary);
    }

    public void maxHeapify(ArrayList<PriorityQueue> queue) {
        int count = 0;
        int sizeOfArray = queue.size();
        int parent;
        while (count < (queue.size() / 2)) {
            parent = (sizeOfArray - 2) / 2;
            if ((sizeOfArray - 1) % 2 == 0) {
                if (queue.get(sizeOfArray - 1).getPriority() > queue.get(sizeOfArray - 2).getPriority()) {
                    if (queue.get(sizeOfArray - 1).getPriority() > queue.get(parent).getPriority()) {
                        swap(queue, sizeOfArray - 1, parent);
                    }
                } else if (queue.get(sizeOfArray - 1).getPriority() < queue.get(sizeOfArray - 2).getPriority()) {
                    if (queue.get(sizeOfArray - 2).getPriority() > queue.get(parent).getPriority()) {
                        swap(queue, sizeOfArray - 2, parent);
                    }
                }
                sizeOfArray -= 2;
            } else if ((sizeOfArray - 1) % 2 == 1) {
                if (queue.get(sizeOfArray - 1).getPriority() > queue.get(parent).getPriority()) {
                    swap(queue, sizeOfArray - 1, parent);
                }
                sizeOfArray -= 1;
            }
            count++;
        }
    }

    public void addToQueue(ArrayList<PriorityQueue> queue, Integer priority, String data) {
        PriorityQueue newNode = new PriorityQueue(priority, data);
        queue.add(newNode);
        maxHeapify(queue);
    }

    public String deleteFromQueue(ArrayList<PriorityQueue> queue) {
        String data = null;
        if (isQueueEmpty(queue)) {
            System.out.println("Queue is empty");
        } else {
            data = queue.get(0).getData();
            queue.remove(0);
            maxHeapify(queue);
        }
        return data;
    }

    public boolean isQueueEmpty(ArrayList<PriorityQueue> queue) {
        if (queue.size() == 0) {
            return true;
        }
        return false;
    }

    public PriorityQueue peek(ArrayList<PriorityQueue> queue) {
        PriorityQueue value = null;
        if (isQueueEmpty(queue)) {
            System.out.println("Queue is empty");
        } else {
            value = queue.get(0);
        }
        return value;
    }
}
