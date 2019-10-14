public class Pair<T extends Comparable> {

    private T first;

    private T second;

    public Pair(){
        this.first = null;
        this.second = null;
    }

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public T max(){
        if( first.compareTo(second) >= 0)
            return first;
        else
            return second;
    }
}


//class Demo{
//    public static void main(String[] args) {
//        Pair<Integer> pair = new Pair<Integer>(5, 19);
//        System.out.println(pair.max());
//    }
//}

