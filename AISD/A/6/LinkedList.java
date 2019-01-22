public class LinkedList {

    private ListElem first;

    public LinkedList()
    {
        first = null;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public ListElem getFirst() {
        return first;
    }

    public void insertFirst(int value) {
        ListElem newElem = new ListElem(value);
        newElem.next = first;
        first = newElem;
    }

    public boolean find(int elem)
    {
        if (isEmpty()) {
            return false;
        }

        ListElem current = first;
        while (current.iData != elem) {
            if (current.next == null) {
                return false;
            } else {
                current = current.next;
            }
        }
        return true;
    }

    public ListElem deleteFirst()
    {
        if (isEmpty()) {
            return null;
        }
        ListElem temp = first;
        first = first.next;
        return temp;
    }

    public ListElem delete(int elem)
    {
        if (isEmpty()) {
            return null;
        }

        ListElem current = first;
        ListElem previous = null;

        while (current.iData != elem) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (previous == null)
        {
            first = first.next;
        } else
        {
            previous.next = current.next;
        }

        return current;
    }

    public LinkedListIterator iterator() {
        return new LinkedListIterator(this);
    }


    public void print() {
        System.out.print("Lista: ");
        LinkedListIterator iterator = this.iterator();

        while (iterator.hasNext())
        {
            ListElem elem = iterator.next();
            System.out.print(elem.toString() + " ");
        }
        System.out.println();
    }
}
