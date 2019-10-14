public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public LinkedList(){
        head=null;
        size=0;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public void setHead(Node<T> n) {
        this.head=n;
    }

    public boolean addElement(T newElement) {
        if(size==0){
            this.setHead(new Node<>(newElement));
            size++;}
        else {
            Node<T> pointer = this.getHead();
            while(pointer.getNext()!=null){
                pointer=pointer.getNext();
            }
            pointer.setNext(new Node<>(newElement));
            size++;
        }
        return true;
    }

    public boolean removeElement(int n){
        if (n >this.size || size==0 || n==0)
        {   System.out.println("Go suck a dick");
            return false;
        }
        else if(n==1){
            this.setHead(this.getHead().getNext());
            return true;
        }
        else{
            Node pointer = this.getHead();
            Node previous=null;
            for(int i =1;i<n;i++){
                previous = pointer;
                pointer = pointer.getNext();
            }
            previous.setNext(pointer.getNext());
            return true;
        }

    }


    public void printAll(){
        Node pointer = head;
        while(pointer!= null){
            System.out.println(pointer.getData());
            pointer=pointer.getNext();
        }
    }




    public static void main(String[] args){

        LinkedList llist = new LinkedList<String>();


        llist.addElement("momma");
        llist.addElement("dances");
        llist.addElement("all night");

        llist.removeElement(0);
        llist.printAll();


    }
}


