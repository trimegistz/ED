public class LinkedList<T>{

    private int size = 0;
    private Node<T> head;

    public void setHead(Node<T> n){
        n.setPrevious(null);
        this.head=n;
    }

    public Node<T> getHead(){
        return this.head;
    }

    public void add(T newElement) {

        Node<T> newNode = new Node<>(newElement);
        if (size == 0)
            this.setHead(newNode);

        else {
            head.setPrevious(newNode);
            newNode.setNext(head);
            this.setHead(newNode);
        }
        size++;
    }


    public void removeFirst() {

        if (size == 0)
            System.out.println("List is already empty");

        if (size == 1)
            head = null;

        if (size >= 2) {
            head = head.getNext();
            head.setPrevious(null);
        }
        size--;
    }

    public void removeLast() {

        if (size == 0)
            System.out.println("List is already empty");

        if (size == 1)
            head = null;


        if (size >= 2) {
            Node<T> pointer = head;
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }

            Node<T> previousNode = pointer.getPrevious();
            previousNode.setNext(null);
        }

        size--;
    }

    public void display() {

        Node<T> pointer = head;
        int i = 0;

        if (size == 0) {
            System.out.println("No data to be displayed");
        } else {
            while (i++ < size) {
                System.out.println("Node " + i + ": " + pointer.getData());
                pointer = pointer.getNext();

            }
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {

        if (size == 0)
            return true;
        else
            return false;
    }

    public void removeSame(T n){

        while(this.head.getData().equals(n)){
            System.out.println("studd");
            this.setHead(this.head.getNext());
        }

        Node<T> pointer = this.getHead();

        while(pointer.getNext()!=null){
            if(pointer.getData().equals(n)){
                Node<T> next = pointer.getNext();
                Node<T> previous = pointer.getPrevious();
                next.setPrevious(previous);
                previous.setNext(next);
                pointer = next;
                size--;
            }else {
                pointer = pointer.getNext();
            }
        }
    }

    public LinkedList<T> pairs(){
        LinkedList<T> pair = new LinkedList<>();
        boolean pairFlag=false;
        boolean headFlag=true;
        Node<T> pointer =  this.head;
        Node<T> setter = null;
        for(int i =0; i < this.size;i++){
            if(pairFlag) {
                if(headFlag){
                    pair.setHead(pointer);
                    pair.head.setNext(null);
                    setter=pair.head;
                    headFlag= !headFlag;
                }else {
                    setter.setNext(pointer);
                    setter.getNext().setPrevious(setter);
                    setter.getNext().setNext(null);
                    setter = setter.getNext();
                }
            }
            pointer=pointer.getNext();
            pairFlag=!pairFlag;
        }
        return pair;
    }






    public static void main(String args[]) {

        LinkedList<Integer> st = new LinkedList<>();


        st.add(3);
        st.add(3);
        st.add(5);
        st.add(5);
        st.add(23);
        st.add(23);
        st.add(654);
        st.add(654);
        st.add(12);
        st.add(12);
        st.removeSame(3);
        st.pairs().display();


    }
}



