package queueImplementation;

public class QueueUsingArray implements QueueInterface<Integer>{
    private Integer front;
    private Integer rear;
    private Integer[] queue;
    QueueUsingArray() {
        queue=new Integer[5];
        front=-1;
        rear=-1;
    }
    public Integer addItemToQueue(Integer item) {
        if(isQueueFull()) {
            return -1;
        }
        else {
            if(front==-1 && rear==-1) {
                front++;
                rear++;
                queue[front]=item;
            }
            else {
                front++;
                queue[front]=item;
            }
            return queue[front];
        }
    }
    public Integer deleteItemFromQueue() {
        if(isQueueEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        else {
            Integer deletedItem=queue[rear];
            rear++;
            return deletedItem;
        }
    }
    public boolean isQueueFull() {
        if(front==(queue.length-1)) {
            return true;
        }
        return false;
    }
    public boolean isQueueEmpty() {
        if((front==rear && front==-1) || (rear>front)) {
            return true;
        }
        return false;
    }
}
