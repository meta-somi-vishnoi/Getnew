package priorityqueue;
interface PriorityQueueInterface {
    public String addToQueue(Integer priority, String data);
    public String deleteFromQueue();
    public boolean isQueueEmpty();
    public String peek();
}