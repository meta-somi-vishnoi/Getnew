package undirectedweightedgraphimplementation;

interface StackInterface<T> {
    public void pushInStack(T value);

    public T popFromStack();

    public boolean isStackEmpty();

    public T getTop();
}
