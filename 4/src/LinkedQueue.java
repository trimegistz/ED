public class LinkedQueue<T> implements QueueADT<T>
{

    public LinearNode<T> first;
    public int size;

    public LinkedQueue(){
        this.size=0;
        this.first=null;
    }


    public void enqueue(T element){
        LinearNode<T> newNode = new LinearNode<>(element);
        if(size!=0)
            newNode.setNext(this.first);
        this.first=newNode;
        size++;
    }


    public T dequeue() throws EmptyQueueException{
        if (isEmpty()) throw new EmptyQueueException("Queue is empty");
        LinearNode<T> counter = this.first;
        while(counter.getNext().getNext()!=null){
            counter=counter.getNext();
        }
        LinearNode<T> byeNode = counter.getNext();
        counter.setNext(null);
        size--;
        return byeNode.getElement();

    }


    public T first() throws EmptyQueueException{
        if (isEmpty()) throw new EmptyQueueException("Queue is empty");
        LinearNode<T> counter = this.first;
        while(counter.getNext()!=null){
            counter=counter.getNext();
        }
        return counter.getElement();
    }


    public boolean isEmpty(){
        if (size()==0)
            return true;
        return false;
    }

    public int size(){
        return this.size;
    }

    @Override
    public String toString(){
        if (isEmpty()) return "Queue is empty";
        LinearNode<T> counter = this.first;
        String s = "";
        while(counter!=null){
            s+= "\n" +counter.getElement();
            counter=counter.getNext();
        }
        return s;
    }


    public static void main(String args[]){
        LinkedQueue<Integer> myQueue = new LinkedQueue<>();
        myQueue.enqueue(23);
        myQueue.enqueue(1);
        myQueue.enqueue(89);
        myQueue.enqueue(12);

        try {
            System.out.println(myQueue.dequeue());
            System.out.println(myQueue.dequeue());
            System.out.println(myQueue.dequeue());
            System.out.println(myQueue.toString());


        }catch (EmptyQueueException er){er.getMessage();}
    }

}
