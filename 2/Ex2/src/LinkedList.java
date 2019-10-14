public class LinkedList<T>{

    private int size = 0;
    private Node<T> head;

    private void setHead(Node<T> n){
        n.setPrevious(null);
        this.head=n;
    }

    public Node<T> getHead(){
        return this.head;
    }

    public void add(T newElement) {

        Node<T> newNode = new Node<>(newElement);
        if (this.getSize() == 0)
            this.setHead(newNode);

        else {
            head.setPrevious(newNode);
            newNode.setNext(head);
            this.setHead(newNode);
        }
        this.size++;
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

        if (this.isEmpty()) {
            System.out.println("No data to be displayed");
        } else {
            for (int i = 0;i < size;i++) {
                System.out.println("Node " + (i+1) + ": " + pointer.display());
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
            this.setHead(this.head.getNext());
        }

        if(!this.isEmpty()){
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
    }

    public LinkedList<T> pairs() {

        LinkedList<T> pair = new LinkedList<>();

        if (size >= 2) {
            boolean pairFlag = false;
            Node<T> pointer = this.getHead().getNext().getNext();
            pair.add(this.getHead().getNext().getData());

            for (int i = 2; i < this.size; i++) {
                if (pairFlag) {
                    pair.add(pointer.getData());
                }
                if(pointer.getNext()!=null)
                    pointer = pointer.getNext();
                pairFlag = !pairFlag;
            }
        }
        return pair;
    }






    public static void main(String args[]) {

        LinkedList<Integer> st = new LinkedList<>();

        st.add(10);
        st.add(9);
        st.add(8);
        st.add(7);
        st.add(6);
        st.add(5);
        st.add(4);
        st.add(3);
        st.add(2);
        st.add(1);

        LinkedList<Integer> pa = st.pairs();
        pa.display();
    }
}



