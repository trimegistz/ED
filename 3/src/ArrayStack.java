
public class ArrayStack<T>  {

    /**
     * constant to represent the default capacity of the array
     */
    private final int DEFAULT_CAPACITY = 100;

    /**
     * in that represents both the number of elements ant the next available
     * position in the array
     */
    private int top;

    /**
     * array of generic elements to represent the stack
     */
    private T[] stack;

    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack() {
        this.top = 0;
        this.stack = (T[]) (new Object[this.DEFAULT_CAPACITY]);
    }

    /**
     * Creates an empty stack using the specified capacity.
     *
     * @param initialCapacity represents the specified capacity
     */
    public ArrayStack(int initialCapacity) {
        this.top = 0;
        this.stack = (T[]) (new Object[initialCapacity]);
    }


    private void expandCapacity() {
        T[] tempStack = (T[]) (new Object[this.stack.length + 10]);

        for (int i = 0; i < this.top; i++) {
            tempStack[i] = this.stack[i];
        }

        this.stack = tempStack;
    }

    /**
     * Adds the specified element to the top of this stack, expanding the capacity
     * of the stack array if necessary. * @param element generic element to be
     * pushed onto stack
     */
    public void push(T element) {
        if (size() == this.stack.length) {
            expandCapacity();
        }

        this.stack[this.top] = element;
        this.top++;
    }

    /**
     * Removes the element at the top of this stack and returns a reference to it.
     * Throws an EmptyCollectionException if the stack is empty. * @return T element
     * removed from top of stack
     *
     * @throws EmptyCollectionException if a pop is attempted on empty stack
     */

    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        this.top--;
        T result = this.stack[this.top];
        this.stack[this.top] = null;
        return result;
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
        return this.stack[this.top - 1];
    }

    /**
     * Return number of elements in the stack
     *
     * @return int number of elements
     */
    public int size() {
        return this.top;
    }

    /**
     * Method to return if the stack is empty or not
     *
     * @return boolean true if stack is empty or false if the stack have elements
     */
    public boolean isEmpty() {
        if (this.top==0) {
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
        for (int i = 0; i <= this.top-1; i++) {
            strBuild.append(this.stack[i].toString() + "\n");
        }

        return strBuild.toString();
    }

    public static void main(String[] args){

        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(3);
        stack.push(7);
        stack.push(45);
        stack.push(34);
        stack.push(23);
        stack.push(12);
        stack.push(23);
        try{




           System.out.println(stack.pop());
           System.out.println(stack.toString());


        }catch (EmptyCollectionException ec){System.out.println("Empty collection");}

    }

}


