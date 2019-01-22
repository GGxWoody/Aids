import java.util.LinkedList;

public class LinkedListList {

    private LinkedList<Object> oList;

    public LinkedListList() {
        oList = new LinkedList<>();
    }

    public boolean isEmpty() {
        return oList.isEmpty();
    }

    public void insertFirst(Object elem) {
        oList.addFirst(elem);
    }

    public void insertLast(Object elem) {
        oList.addLast(elem);
    }

    public Object deleteFirst() {
        return oList.removeFirst();
    }

    public Object deleteLast() {
        return oList.removeLast();
    }

    public Object getFirst() {
        return oList.getFirst();
    }

    public Object getLast() {
        return oList.getLast();
    }

    public int size() {
        return oList.size();
    }

    public void print() {
        for (int i = 0; i < oList.size(); i++) {
            System.out.print(oList.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListList theList = new LinkedListList();

        theList.insertFirst(99);
        theList.insertFirst(11);
        theList.insertFirst(22);

        theList.insertLast(55);
        theList.insertLast(44);
        theList.insertLast(22);

        theList.print();

        theList.deleteFirst();
        theList.deleteFirst();

        theList.print();

        theList.deleteLast();

        theList.print();
    }

}
