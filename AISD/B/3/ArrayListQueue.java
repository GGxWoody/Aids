import java.util.ArrayList;

public class ArrayListQueue {

    private ArrayList<Integer> intQueue;

    public ArrayListQueue() {
        intQueue = new ArrayList<>();
    }

    public void insert(int elem) {
        intQueue.add(elem);
    }

    public int remove() {
        int firstElem = intQueue.get(0);
        intQueue.remove(0);
        return firstElem;
    }

    public int peek() {
        return intQueue.get(0);
    }

    public boolean isEmpty() {
        return intQueue.isEmpty();
    }

    public int size() {
        return intQueue.size();
    }

    public static void main(String[] args) {
        ArrayListQueue theQueue = new ArrayListQueue();


        theQueue.insert(10);
        theQueue.insert(20);

        System.out.println(" Usuwam: " + theQueue.remove());

        theQueue.insert(50);
        theQueue.insert(60);
        
        System.out.println(" Usuwam: " + theQueue.remove());
    }
}
