package stackAndQueueImplementation;

interface QueueInterface<T> {
    public T addItemToQueue(T item);

    public T deleteItemFromQueue();

    public boolean isQueueEmpty();
}
