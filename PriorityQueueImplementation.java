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
        this.priority=priority;
        this.data=data;
    }
    public Integer getPriority() {
        return priority;
    }
    public void setPriority(Integer value) {
        priority=value;
    } 
    public String getData() {
        return data;
    }
}
public class PriorityQueueImplementation implements PriorityQueueInterface{
    public ArrayList<PriorityQueue> queue = new ArrayList<PriorityQueue>();
    public void swap(Integer first, Integer second) {
        PriorityQueue temporary = queue.get(first);
        queue.set(second,queue.get(first));
        queue.set((first),temporary);
    }
    public void maxHeapify() {
     /*   int count=0;
        int sizeOfArray=queue.size();
        int parent;
        int index=queue.size();
        while(count<(queue.size()/2)) {
            parent=(sizeOfArray-1)/2;
            if((sizeOfArray-1)%2==0) {
                if(queue.get(sizeOfArray-1).getPriority()>queue.get(sizeOfArray-2).getPriority()) { 
                    if(queue.get(sizeOfArray-1).getPriority()>queue.get(parent).getPriority()) {
                        swap(sizeOfArray-1,parent);
                    }
                }
                else if(queue.get(sizeOfArray-1).getPriority()<queue.get(sizeOfArray-2).getPriority()){
                    if(queue.get(sizeOfArray-2).getPriority()>queue.get(parent).getPriority()) {
                    swap(sizeOfArray-2,parent);
                    }
                }
                sizeOfArray-=2;
            }
            else {
                if(queue.get(sizeOfArray-1).getPriority()>queue.get(parent).getPriority()) {
                    swap(sizeOfArray-1,parent);
                }
                sizeOfArray-=1;
            }
            count++;
        }*/
    /* if(queue.size()>1) {
        for(int i=0;i<queue.size()-1;i++) {
            for(int j=0;j<(queue.size()-i-i);j++) {
                if(queue.get(j).getPriority()<queue.get(j+1).getPriority()) {
                    swap(j,j+1);
                }
            }
        }
     }*/
    }
    public String addToQueue(Integer priority, String data) {
        PriorityQueue newNode = new PriorityQueue(priority,data);
        queue.add(newNode);
        maxHeapify();
        for(int i=0;i<queue.size();i++)
        System.out.print(queue.get(i).getData());
        System.out.println(" ");
        return peek();
    }
    public String deleteFromQueue() {
        String data=null;
        if(isQueueEmpty()) {
            System.out.println("Queue is empty");
        } 
        else {
            data=queue.get(0).getData();
            queue.remove(0);
            maxHeapify();
        }
        return data;
    }
    public boolean isQueueEmpty() {
        if(queue.size()==0) {
            return true;
        }
        return false;
    }
    public String peek() {
        String value=null;
        if(isQueueEmpty()) {
            System.out.println("Queue is empty");
        } 
        else {
            value=queue.get(0).getData();
        }
        return value;
    }
}
