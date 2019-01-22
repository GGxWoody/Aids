import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetSet {

    private TreeSet<Integer> treeSet;

    public TreeSetSet()
    {
        treeSet = new TreeSet<>();
    }

    public TreeSet<Integer> getTreeSet() {
        return treeSet;
    }

    public int size()
    {
        return treeSet.size();
    }

    public void insert(int elem)
    {
        if (!member(elem))
        {
            treeSet.add(elem);
        }
    }

    public boolean member(int elem)
    {
        return treeSet.contains(elem);
    }

    public boolean delete(int elem)
    {
        if (member(elem))
        {
            treeSet.remove(elem);
            return true;
        } else {
            return false;
        }
    }

    public TreeSetSet union(TreeSetSet secondSet)
    {
        TreeSetSet unionSet = new TreeSetSet();
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            int locElem = iterator.next();
            unionSet.insert(locElem);
        }

        Iterator<Integer> iteratorS = secondSet.getTreeSet().iterator();
        while (iteratorS.hasNext()) {
            int locElem = iteratorS.next();
            unionSet.insert(locElem);
        }

        return unionSet;
    }

    public TreeSetSet intersection(TreeSetSet secondSet)
    {
        TreeSetSet intersectionSet = new TreeSetSet();

        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            int locElem = iterator.next();
            if (secondSet.member(locElem)) {
                intersectionSet.insert(locElem);
            }
        }

        return intersectionSet;
    }

    public TreeSetSet difference(TreeSetSet secondSet)
    {
        TreeSetSet differenceSet = new TreeSetSet();

        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            int locElem = iterator.next();
            if (!secondSet.member(locElem)) {
                differenceSet.insert(locElem);
            }
        }

        return differenceSet;
    }

    public void print() {
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            int locElem = iterator.next();
            System.out.print(locElem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeSetSet theSetA = new TreeSetSet();
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
        TreeSetSet theSetB = new TreeSetSet();
        theSetB.insert(44);
        theSetB.insert(77);
        theSetB.insert(66);
        theSetB.insert(88);

        System.out.println("Zbior B:");
        theSetB.print();

        System.out.println("Zbior B:");
        theSetB.print();

        TreeSetSet unionSet = theSetA.union(theSetB);
        System.out.println("Suma A i B:");
        unionSet.print();

        TreeSetSet intersectionSet = theSetA.intersection(theSetB);
        System.out.println("Iloczyn A i B:");
        intersectionSet.print();

        TreeSetSet differenceSet = theSetA.difference(theSetB);
        System.out.println("Roznica A-B:");
        differenceSet.print();
    }
}
