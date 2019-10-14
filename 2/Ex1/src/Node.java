public class Node<T>{

    T data;
    Node next;

    public Node (T d){
        data =d;
        next = null;
    }

    public Node getNext(){
        return this.next;
    }
    public void setNext(Node n){
        this.next=n;
    }

    public String getData(){
        return this.data.toString();
    }
}
