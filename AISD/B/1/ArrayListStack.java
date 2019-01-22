import java.util.ArrayList;

public class ArrayListStack {

    private final ArrayList<Integer> intStack;

    public ArrayListStack() {
        intStack = new ArrayList<>();
    }
    
    public void push(int elem) {
        intStack.add(elem);
    }

    public int pop() {
        int topElem = intStack.get(intStack.size() - 1);
        intStack.remove(intStack.size() - 1);
        return topElem;
    }

    public long peek() {
        return intStack.get(intStack.size() - 1);
    }

    public boolean isEmpty() {
        return intStack.isEmpty();
    }

    public static void main(String[] args) {
        ArrayListStack theStack = new ArrayListStack();
        theStack.push(11);
        theStack.push(44);
        theStack.push(66);
        theStack.push(88);
        System.out.println(theStack.peek());
        System.out.println(theStack.isEmpty());

        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.print(value + " ");
        }
        System.out.println("");
    }
}
