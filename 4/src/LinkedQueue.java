public class LinkedQueue<T> implements QueueADT<T>
{

    public LinearNode<T> rear,front;
    public int size;

    public LinkedQueue(){
        this.size=0;
        this.rear=null;
        this.front=null;
    }


    public void enqueue(T element){
        LinearNode<T> newNode = new LinearNode<>(element);

        if(size==0)
            this.front=newNode;
        else
            rear.setNext(newNode);

        this.rear=newNode;
        size++;
    }


    public T dequeue() throws EmptyQueueException{
        if (isEmpty()) throw new EmptyQueueException("Queue is empty");

        T returnable= front.getElement();

        front = front.getNext();
        size--;
        return returnable;

    }

    public T first() throws EmptyQueueException{
        if (isEmpty()) throw new EmptyQueueException("Queue is empty");

        return front.getElement();
    }

    public LinearNode<T> getBeginning(){
        return front;
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
        LinearNode<T> counter = this.front;
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
            System.out.println(myQueue.toString());


        }catch (EmptyQueueException er){er.getMessage();}
    }

}
