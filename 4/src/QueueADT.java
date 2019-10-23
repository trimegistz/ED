public interface QueueADT<T> {

    public void enqueue(T element);
    public T dequeue() throws EmptyQueueException;
    public T first() throws EmptyQueueException;
    public boolean isEmpty();
    public int size();

    @Override
    public String toString() ;

}
