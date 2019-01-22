public class DynamicArray {
    
    Object[] table;
    int nElements;
    
    public DynamicArray(int startSize) {
        this.table = new Object[startSize];
        this.nElements = 0;
    }
    
    public void add(Object value) {
        if (nElements >= table.length) {
            Object[] tempTab = new Object[table.length * 2];
            for (int i = 0; i < table.length; i++) {
                tempTab[i] = table[i];
            }
            table = tempTab;
        }
        table[nElements] = value;
        nElements++;
    }
    
    public Boolean remove(int index) {
        if (nElements == 0 || nElements < index) {
            return false;
        }
        for (int i = index; i < nElements - 1; i++) {
            table[i] = table[i + 1];
        }
        nElements--;
        return true;
    }
    
    public int find(Object value) {
        for (int i = 0; i < nElements; i++) {
            if (table[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
    
    public void print() {
        System.out.print("Lista: ");
        for (int i = 0; i < nElements; i++) {
            System.out.print(table[i].toString() + " ");
        }
        System.out.println("");
    }
    
    public int size(){
        return nElements;
    }

    public static void main(String[] args) {
        DynamicArray array = new DynamicArray(2);
        array.add(5);
        array.add("Coś");
        array.add(7.141);
        
        array.print();
        System.out.println(array.find("Coś"));
        System.out.println(array.size());
        array.remove(1);
        array.print();
        
    }
}
