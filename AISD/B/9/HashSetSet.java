
import java.util.HashSet;
import java.util.Iterator;

public class HashSetSet {

    private final HashSet<Integer> hashTable;

    public HashSetSet() {
        hashTable = new HashSet<>();
    }

    public HashSet<Integer> getHashTable() {
        return hashTable;
    }

    public int size() {
        return hashTable.size();
    }

    public void insert(int elem) {
        if (!member(elem)) {
            hashTable.add(elem);
        }
    }

    public boolean member(int elem) {
        return hashTable.contains(elem);
    }

    public boolean delete(int elem) {
        if (member(elem)) {
            hashTable.remove(elem);
            return true;
        } else {
            return false;
        }
    }

    public HashSetSet union(HashSetSet secondSet) {
        HashSetSet unionSet = new HashSetSet();
        Iterator<Integer> iterator = hashTable.iterator();
        while (iterator.hasNext()) {
            int locElem = iterator.next();
            unionSet.insert(locElem);
        }

        Iterator<Integer> iteratorS = secondSet.getHashTable().iterator();
        while (iteratorS.hasNext()) {
            int locElem = iteratorS.next();
            unionSet.insert(locElem);
        }

        return unionSet;
    }

    public HashSetSet intersection(HashSetSet secondSet) {
        HashSetSet intersectionSet = new HashSetSet();

        Iterator<Integer> iterator = hashTable.iterator();
        while (iterator.hasNext()) {
            int locElem = iterator.next();
            if (secondSet.member(locElem)) {
                intersectionSet.insert(locElem);
            }
        }

        return intersectionSet;
    }

    public HashSetSet difference(HashSetSet secondSet) {
        HashSetSet differenceSet = new HashSetSet();

        Iterator<Integer> iterator = hashTable.iterator();
        while (iterator.hasNext()) {
            int locElem = iterator.next();
            if (!secondSet.member(locElem)) {
                differenceSet.insert(locElem);
            }
        }

        return differenceSet;
    }

    public void print() {
        Iterator<Integer> iterator = hashTable.iterator();
        while (iterator.hasNext()) {
            int locElem = iterator.next();
            System.out.print(locElem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HashSetSet theSetA = new HashSetSet();
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

        HashSetSet theSetB = new HashSetSet();
        theSetB.insert(44);
        theSetB.insert(77);
        theSetB.insert(66);
        theSetB.insert(88);

        System.out.println("Zbior B:");
        theSetB.print();

        HashSetSet intersectionSet = theSetA.intersection(theSetB);
        System.out.println("Iloczyn A i B:");
        intersectionSet.print();

        HashSetSet unionSet = theSetA.union(theSetB);
        System.out.println("Suma A i B:");
        unionSet.print();

        HashSetSet differenceSet = theSetA.difference(theSetB);
        System.out.println("Roznica A-B:");
        differenceSet.print();
    }
}
