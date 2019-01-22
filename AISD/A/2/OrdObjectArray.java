public class OrdObjectArray {

    Person[] table;
    private int nElements;

    public OrdObjectArray(int startSize) {
        this.table = new Person[startSize];
        this.nElements = 0;
    }

    public void add(Person value) {
        if (nElements >= table.length) {
            Person[] tempTab = new Person[table.length * 2];
            for (int i = 0; i < table.length; i++) {
                tempTab[i] = table[i];
            }
            table = tempTab;
        }

        int i;
        for (i = 0; i < nElements; i++) {
            if (table[i].getSecondName().compareTo(value.getSecondName()) > 0) {
                break;
            }
        }
        for (int j = nElements; j > i; j--) {
            table[j] = table[j - 1];
        }
        table[i] = value;
        nElements++;
    }

    public Person get(int index) {
        return table[index];
    }

    public int size() {
        return nElements;
    }

    public Boolean remove(int index) {
        if (nElements == 0 || index > nElements) {
            return false;
        }
        for (int i = index; i < nElements - 1; i++) {
            table[i] = table[i + 1];
        }
        nElements--;
        return true;
    }

    public int find(Person value) {
        for (int i = 0; i < nElements; i++) {
            if (table[i].getFirstName().equals(value.getFirstName()) && table[i].getSecondName().equals(value.getSecondName()) && table[i].getAge() == value.getAge()) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < nElements; i++) {
            System.out.println(table[i].toString());
        }
    }

    public static void main(String[] args) {
        OrdObjectArray array = new OrdObjectArray(2);
        Person p1 = new Person("Ala", "Ktoś", 21);
        Person p2 = new Person("Bartosz", "Wolano", 17);

        array.add(p2);
        array.add(p1);

        array.print();
        System.out.println(array.find(p2));

        array.remove(0);
        array.size();
        array.print();
    }
}
