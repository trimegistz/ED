public class CircularQueue<T> implements QueueADT<T>{


    public int size, rear,front;
    public final int DEFAULT_INITIAL_SIZE=8;
    public final int DEFAULT_INCREMENT=5;
    public T[] myarray;


    public CircularQueue(){
        rear=front=size=0;
        myarray=(T[])new Object[DEFAULT_INITIAL_SIZE];
    }

    public void expandCapacity(){

        T[] newArray= (T[])new Object[myarray.length+DEFAULT_INCREMENT];
        int counter = front;
        int t =0;

        while(t<size){
            newArray[t]=myarray[counter];
            counter= (counter+1) % myarray.length;
            t++;
        }

        myarray=newArray;
        front=0;
        rear=t;

    }

    public void enqueue(T element) {

        if (isFull() ) expandCapacity();

        myarray[rear] = element;
        rear= (rear + 1) % myarray.length;
        size++;
    }

    public T dequeue() throws EmptyQueueException{
        if(size==0) throw new EmptyQueueException("Array is Empty");
        T temp = myarray[front];
        myarray[front] = null;

        front=(front+1) % myarray.length;
        size--;

        return temp;
    }


    public T first() throws EmptyQueueException{
        if (isEmpty()) throw new EmptyQueueException("Queue is Empry");
        return myarray[front];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean isFull(){
        if(myarray.length==size)
            return true;
        return false;
    }
    public String toString(){
        String s = "";
        int i = front;
        while(i!=rear){
            s+= "\n" +myarray[i].toString();
            i=(i+1) % myarray.length;
        }
        return s;
    }

    public static void main(String args[]){
        CircularQueue<Integer> queue = new CircularQueue<>();

        queue.enqueue(23);
        queue.enqueue(41);
        queue.enqueue(242);
        queue.enqueue(242);
        queue.enqueue(242);
        queue.enqueue(242);
        queue.enqueue(242);
        queue.enqueue(242);
        queue.enqueue(242);
        queue.enqueue(432);
        queue.enqueue(543);
        queue.enqueue(54);
        queue.enqueue(12);

        try {

            System.out.println(queue.first());
        }catch (EmptyQueueException e){e.getMessage();}

    }

}
