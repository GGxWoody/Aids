public class FirstLastLinkedList {

    DListElement first;
    DListElement last;

    public FirstLastLinkedList() {
        first = null;
        last = null;
    }

    public Boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(Object value) {
        DListElement insert = new DListElement(value);
        if (isEmpty()) {
            last = insert;
        } else {
            first.previous = insert;
        }
        insert.next = first;
        first = insert;
    }

    public void insertLast(Object value) {
        DListElement insert = new DListElement(value);
        if (isEmpty()) {
            first = insert;
        } else {
            last.next = insert;
            insert.previous = last;
        }
        last = insert;
    }
    
    public Boolean deleteFirst(){
        if (isEmpty()) {
            return false;
        }
        if (first.next == null) {
          last = null;  
        }else{
            first.next.previous = null;
        }
        first = first.next;
        return true;
    }
    
    public Boolean deleteLast(){
        if (isEmpty()) {
            return false;
        }
        if (last.previous == null) {
            first = null;
        }else{
            last.previous.next = null;
        }
        last = last.previous;
        return true;
    }
    
    public void print(){
        System.out.print("Lista: ");
        DListElement current = first;
        while (current != null) {            
            System.out.print(current.value.toString() + " ");
            current = current.next;
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        FirstLastLinkedList lista = new FirstLastLinkedList();
        lista.insertFirst(1);
        lista.insertLast("Okoń");
        lista.insertLast(7.43532);

        lista.print();
    }
}
