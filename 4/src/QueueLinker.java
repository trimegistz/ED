public class QueueLinker<T>{
    public LinkedQueue<T> joiner(LinkedQueue<T> queue1, LinkedQueue<T> queue2) throws EmptyQueueException{
        LinkedQueue<T> result = queue1;
        result.rear.setNext(queue2.getBeginning());
        return result;
    }
}
