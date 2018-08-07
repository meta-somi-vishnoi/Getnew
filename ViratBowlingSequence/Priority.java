package priorityqueue;
interface PriorityQueueInterface {
    public void addToQueue(Integer priority, String data);
    public String deleteFromQueue();
    public boolean isQueueEmpty();
    public PriorityQueue peek();
}