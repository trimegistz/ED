import javax.sound.sampled.Line;

public class LinkedArrayStack<T>  {

    /**
     * constant to represent the default capacity of the array
     */
    private final int DEFAULT_CAPACITY = 100;

    /**
     * in that represents both the number of elements ant the next available
     * position in the array
     */
    private LinearNode<T> top;
    private int size;

    public LinkedArrayStack() {
        this.top = null;
        this.size =0 ;
    }

    public void push(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);


        if (size() == 0) {
            this.top=newNode;
        }else{
            LinearNode<T> counter=top;
            while(counter.getNext()!=null){
                counter=counter.getNext();
            }
            counter.setNext(newNode);
        }
        size++;
    }

    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        if(size==1){
            T el = top.getElement();
            this.top=null;
            return el;

        }
        LinearNode<T> counter=top;
        while(counter.getNext().getNext()!=null){
            counter=counter.getNext();
        }
        LinearNode<T> out = counter.getNext();
        counter.setNext(null);
        return out.getElement();
    }


    /**
     * Returns a reference to the element at the top of this stack. The element is
     * not removed from the stack. Throws an EmptyCollectionException if the stack
     * is empty. * @return T element on top of stack
     *
     * @throws EmptyCollectionException if a peek is attempted on empty stack
     */
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        LinearNode<T> counter=top;
        for(int i =0;i<size-1;i++){
            counter=counter.getNext();
        }
        return counter.getElement();
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if (size()==0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to return all elements in one string
     *
     * @return string with all elements
     */
    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        LinearNode<T> counter=top;
        while(counter!=null){
            strBuild.append(counter.getElement() + "\n");
            counter=counter.getNext();
        }
        return strBuild.toString();
    }

    public static void main(String[] args){

        LinkedArrayStack<Integer> array= new LinkedArrayStack<>();
        array.push(34);
        array.push(8);
        array.push(12);
        array.push(343);
        array.push(23);
        try {
            System.out.println(array.pop());
            System.out.println();
        }catch (EmptyCollectionException e){System.out.println("stack is empty");}

        System.out.println(array.toString());

    }

}


