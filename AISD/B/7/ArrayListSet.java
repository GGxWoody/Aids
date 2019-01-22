
import java.util.ArrayList;

public class ArrayListSet {

    private ArrayList<Integer> integerSet;

    public ArrayListSet() {
        integerSet = new ArrayList<>();
    }

    public int size() {
        return integerSet.size();
    }

    public void insert(int elem) {
        if (!member(elem)) {
            integerSet.add(elem);
        }
    }

    public int get(int index) {
        return integerSet.get(index);
    }

    public boolean member(int elem) {
        for (int i = 0; i < size(); i++) {
            if (get(i) == elem) {
                return true;
            }
        }
        return false;
    }

    public boolean delete(int elem) {
        int position = -1;
        for (int i = 0; i < size(); i++) {
            if (integerSet.get(i) == elem) {
                position = i;
                break;
            }
        }

        if (position > -1) {
            integerSet.remove(position);
            return true;
        }

        return false;
    }

    public ArrayListSet union(ArrayListSet secondSet) {
        ArrayListSet unionSet = new ArrayListSet();

        for (int i = 0; i < size(); i++) {
            int locElem = get(i);
            unionSet.insert(locElem);
        }

        for (int i = 0; i < secondSet.size(); i++) {
            int locElem = secondSet.get(i);
            unionSet.insert(locElem);
        }

        return unionSet;
    }

    public ArrayListSet intersection(ArrayListSet secondSet) {
        ArrayListSet intersectionSet = new ArrayListSet();
        for (int i = 0; i < size(); i++) {
            int locElem = get(i);
            if (secondSet.member(locElem)) {
                intersectionSet.insert(locElem);
            }
        }
        return intersectionSet;
    }

    public ArrayListSet difference(ArrayListSet secondSet) {
        ArrayListSet differenceSet = new ArrayListSet();
        for (int i = 0; i < size(); i++) {
            int locElem = get(i);
            if (!secondSet.member(locElem)) {
                differenceSet.insert(locElem);
            }
        }
        return differenceSet;
    }

    public void print() {
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayListSet theSetA = new ArrayListSet();
        theSetA.insert(66);
        theSetA.insert(11);
        theSetA.insert(44);

        theSetA.print();

        boolean test = theSetA.member(20);
        System.out.println(test);

        theSetA.print();

        test = theSetA.member(22);
        System.out.println(test);

        theSetA.insert(22);

        theSetA.print();

        test = theSetA.member(22);
        System.out.println(test);

        theSetA.delete(22);

        theSetA.print();

        test = theSetA.member(22);
        System.out.println(test);

        theSetA.insert(11);
        theSetA.insert(99);

        System.out.println("Zbior A:");
        theSetA.print();

        ArrayListSet theSetB = new ArrayListSet();
        theSetB.insert(44);
        theSetB.insert(77);
        theSetB.insert(66);
        theSetB.insert(88);

        System.out.println("Zbior B:");
        theSetB.print();

        ArrayListSet intersectionSet = theSetA.intersection(theSetB);
        System.out.println("Iloczyn A i B:");
        intersectionSet.print();

        ArrayListSet unionSet = theSetA.union(theSetB);
        System.out.println("Suma A i B:");
        unionSet.print();

        ArrayListSet differenceSet = theSetA.difference(theSetB);
        System.out.println("Roznica A-B:");
        differenceSet.print();
    }
}
