import java.lang.reflect.Array;

public class postFix {


    public static int calculator(String calculations) throws EmptyCollectionException{
        ArrayStack<Integer> array =new ArrayStack<Integer>();

        int x =0;
        int y =0;

        String[] part = calculations.split(" ");
        for(int i=0;i<part.length;i++){
            switch(part[i]){
                case "*": array.push(array.pop() * array.pop());break;

                case "/":
                    x=array.pop();
                    y=array.pop();
                    array.push( y/x );break;

                case "+": array.push(array.pop() + array.pop());break;

                case "-":
                    x=array.pop();
                    y=array.pop();
                    array.push( y-x );
                break;

                default: array.push(Integer.parseInt(part[i]));break;
            }
        }
        return array.peek();
    }

    public static void main(String args[]){

        try {
            System.out.println(postFix.calculator("7 4 3 * 1 5 + / * "));
        }catch (EmptyCollectionException e){System.out.println("Bad input");}
        }

}
