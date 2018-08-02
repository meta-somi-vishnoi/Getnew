package queueImplementation;

public class QueueUsingArray implements QueueInterface{
    private int front;
    private int rear;
    private int[] queue;
    QueueUsingArray() {
        queue=new int[5];
        front=-1;
        rear=-1;
    }
    public int addItemToQueue(int item) {
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
    public int deleteItemFromQueue() {
        if(isQueueEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        else {
            int deletedItem=queue[rear];
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