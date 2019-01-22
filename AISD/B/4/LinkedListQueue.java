import java.util.LinkedList;

public class LinkedListQueue {

    private LinkedList<Integer> intQueue;

    public LinkedListQueue() {
        intQueue = new LinkedList<>();
    }

    public void insert(int elem) {
        intQueue.addLast(elem);
    }

    public int remove() {
        int firstElem = intQueue.get(0);
        intQueue.removeFirst();
        return firstElem;
    }

    public int peek() {
        return intQueue.peekFirst();
    }

    public boolean isEmpty() {
        return intQueue.isEmpty();
    }

    public int size() {
        return intQueue.size();
    }

    public static void main(String[] args) {
        LinkedListQueue theQueue = new LinkedListQueue();

        

        theQueue.insert(10);
        theQueue.insert(20);

        System.out.println(" Usuwam: " + theQueue.remove());

        theQueue.insert(50);
        theQueue.insert(60);
        
        System.out.println(" Usuwam: " + theQueue.remove());
    }
}
