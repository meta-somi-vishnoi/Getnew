package stackAndQueueImplementation;

public class CircularQueueUsingArray implements QueueInterface<Integer>{
    private Integer rear;
    private Integer front;
    private Integer[] queue;
    CircularQueueUsingArray() {
        queue=new Integer[5];
        rear=-1;
        front=-1;
    }
    public Integer addItemToQueue(Integer item) {
        if(isQueueFull()) {
            return -1;
        }
        else {
            if(rear==-1 && front==-1) {
                rear++;
                front++;
            }
            else if(rear==(queue.length-1) && front>0) {
                rear=0; 
            }
            else {
                rear++;
            }
            queue[rear]=item;
            return queue[rear];
        }
    }
    public Integer deleteItemFromQueue() {
        if(isQueueEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        Integer deletedItem=queue[front];
        if(front==rear) {
            front=-1;
            rear=-1;
        }
        else if(front==queue.length-1) {
            front=0;
        }
        else {
            front++;
        }
        return deletedItem;
    }
    public boolean isQueueFull() {
        if((rear==(queue.length-1) && front==0) || (rear==(front-1)%(queue.length-1))) {
            return true;
        }
        return false;
    }
    public boolean isQueueEmpty() {
        if(rear==front && rear==-1) {
            return true;
        }
        return false;
    }
}