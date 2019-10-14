public class UnorderedPair<T extends Comparable> extends Pair<T> {

    public UnorderedPair(){
        setFirst(null);
        setSecond(null);
    }

    public UnorderedPair(T first, T second){
        super(first,second);
    }

    public boolean same(){
        if (getFirst().equals(getSecond())){
            return true;
        }else
            return false;
    }

    public boolean equals(Object otherObject){
        if(otherObject == null){
            return false;
        }else if(getClass() != otherObject.getClass()){
            return false;
        }else{
            UnorderedPair<T> otherPair = (UnorderedPair<T>) otherObject;

            return (getFirst().equals(otherPair.getFirst())
                &&  getSecond().equals(otherPair.getSecond()))
                ||  (getFirst().equals(otherPair.getSecond())
                &&  getSecond().equals(otherPair.getFirst()));
        }
    }
}

class Demo{
    public static void main(String[] args){
        UnorderedPair<String> p1 = new UnorderedPair<String>("stuff","staff");
        UnorderedPair<String> p2 = new UnorderedPair<String>("staff","stuff");
        UnorderedPair<String> p3 = new UnorderedPair<String>("yeah","yeah");

        System.out.println(p1.equals(p2));
        System.out.println(p1.same());
        System.out.println(p3.same());

    }
}


