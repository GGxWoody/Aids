import java.util.ArrayList;

public class ArrayListList {

    private ArrayList<Object> oList;

    public ArrayListList() {
        oList = new ArrayList<>();
    }

    public boolean addLast(Object elem) {
        return oList.add(elem);
    }

    public Object removeLast() {
        int lastIndex = oList.size() - 1;
        return oList.remove(lastIndex);
    }

    public Object get(int index) {
        return oList.get(index);
    }

    public int find(Object elem) {
        return oList.indexOf(elem);
    }

    public int size() {
        return oList.size();
    }

    public void print() {
        for (int i = 0; i < oList.size(); i++) {
            System.out.print(oList.get(i) + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ArrayListList theList = new ArrayListList();

        theList.addLast("coś0");
        theList.addLast("coś1");
        theList.addLast("coś2");
        theList.addLast("coś3");
        theList.addLast("coś4");

        theList.print();
        System.out.println("");

        System.out.println(theList.get(3));
        System.out.println("");

        theList.print();
        System.out.println("");

        System.out.println(theList.removeLast());
        System.out.println("");

        System.out.println(theList.find("coś4"));
        System.out.println("");

        theList.print();
        System.out.println("");
    }

}
