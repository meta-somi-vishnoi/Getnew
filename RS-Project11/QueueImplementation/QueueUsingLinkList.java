package queueImplementation;
class Node {
    int data;
    Node next;
}
public class QueueUsingLinkList implements QueueInterface{
    Node front;
    Node rear;
    QueueUsingLinkList() {
        front=null;
        rear=null;
    }
    public int addItemToQueue(int item) {
        Node newNode = new Node();
        newNode.data=item;
        newNode.next=null;
        if(front==null && rear==null) {
            front=newNode;
            rear=newNode;
        }
        else {
            front.next=newNode;
            front=front.next;
        }
        return front.data;
    } 
    public int deleteItemFromQueue() {
        Node delete = null;
        delete=rear;
        rear=rear.next;
        if(rear==null) {
            front=null;
        }
        return delete.data;
    }
    public boolean isQueueEmpty() {
        if(front==null && rear==null) {
            return true;
        }
        return false;
    }
}