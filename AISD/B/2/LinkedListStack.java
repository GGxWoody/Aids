import java.util.LinkedList;

public class LinkedListStack {

    private LinkedList<Integer> intStack;

    public LinkedListStack() {
        intStack = new LinkedList<>();
    }

    public void push(int elem) {
        intStack.push(elem);
    }

    public int pop() {
        return intStack.pop();
    }

    public int peek() {
        return intStack.peek();
    }

    public boolean isEmpty() {
        return intStack.isEmpty();
    }

    public static void main(String[] args) {
        LinkedListStack theStack = new LinkedListStack();
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while (!theStack.isEmpty())
        {
            long value = theStack.pop();
            System.out.print(value + " ");
        }
        System.out.println("");
    }
}
