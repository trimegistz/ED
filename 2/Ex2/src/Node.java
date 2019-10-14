public  class Node<T>{
    T data;
    Node next;
    Node previous;

    public Node(T data) {

        this.data = data;
        this.previous=null;
        this.next=null;
    }

    public void setNext(Node n) {
        this.next = n;
    }

    public void setPrevious(Node n) {
        this.previous = n;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public Node<T> getPrevious() {
        return this.previous;
    }

    public String getData() {

        if(this.data==null)
            return "No data here";
        else
            return this.data.toString();
    }

}
