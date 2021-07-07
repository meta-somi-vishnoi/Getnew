
package collegeprograms;
public class QueueUsingLinkList implements QueueInterface<Student> {
    Node front;
    Node rear;

    QueueUsingLinkList() {
        front = null;
        rear = null;
    }

    public Student addItemToQueue(Student item) {
        Node newNode = new Node(item,null);
        if (front == null && rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            front.next = newNode;
            front = front.next;
        }
        return front.data;
    }

    public Student deleteItemFromQueue() {
        Node delete = null;
        delete = rear;
        rear = rear.next;
        if (rear == null) {
            front = null;
        }
        return delete.data;
    }

    public boolean isQueueEmpty() {
        if (front == null && rear == null) {
            return true;
        }
        return false;
    }
}
