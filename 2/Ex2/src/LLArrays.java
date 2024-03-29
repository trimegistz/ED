public class LLArrays<T> {

    public T[] getFull(LinkedList<T> list){

        int array_size = list.getSize();
        Node pointer = list.getHead();
        T[] myarray = (T[]) new Object[array_size] ;
        for(int i =0;i<array_size;i++){
            myarray[i] = (T)pointer.getData();
            pointer=pointer.next;
        }
        return myarray;

    }

    public T[] getUntil(LinkedList<T> list, int n){
        Node pointer = list.getHead();
        T[] myarray = (T[]) new Object[n];
        for(int i =0;i<n;i++){
            myarray[i] =(T) pointer.getData();
            pointer=pointer.next;
        }
        return myarray;
    }

    public T[] getAfter(LinkedList<T> list, int n){
        Node pointer = list.getHead();
        T[] myarray = (T[]) new Object[list.getSize()-n];
        for(int i =n;i<list.getSize();i++){
            myarray[i] = (T) pointer.getData();
            pointer=pointer.next;
        }
        return myarray;
    }

    public T[] getBetween(LinkedList<T> list, int start, int finish){
        Node pointer = list.getHead();
        T[] myarray = (T[]) new Object[finish-start];
        for(int i = 0; i<start;i++){
            pointer=pointer.getNext();
        }
        for(int i =start;i<finish;i++){
            myarray[i] = (T) pointer.getData();
            pointer=pointer.getNext();
        }
        return myarray;
    }

    public void display(T[] myArray){
        for (T e: myArray){
            System.out.println(e.toString());
        }
    }

}
