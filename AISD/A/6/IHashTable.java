public class IHashTable {

    private LinkedList[] hashArray;
    private int arraySize;

    public IHashTable(int size)
    {
        arraySize = size;
        hashArray = new LinkedList[size];

        for (int i = 0; i < size; i++)
        {
            hashArray[i] = new LinkedList();
        }
    }

    public LinkedList getLinkedList(int index)
    {
        return hashArray[index];
    }

    public int size()
    {
        return arraySize;
    }

    private int hashFunc(int elem)
    {
        return elem % arraySize;
    }

    public void insert(int data)
    {
        int hashVal = hashFunc(data);
        if (!hashArray[hashVal].find(data))
        {
            hashArray[hashVal].insertFirst(data);
        }
    }

    public void delete(int elem)
    {
        int hashVal = hashFunc(elem);
        hashArray[hashVal].delete(elem);
    }

    public boolean find(int elem)
    {
        int hashVal = hashFunc(elem);
        return hashArray[hashVal].find(elem);
    }

    public IHashTableIterator iterator()
    {
        return new IHashTableIterator(this);
    }

    public void print()
    {
        System.out.print("Tablica mieszajaca:");
        IHashTableIterator iterator = this.iterator();

        while (iterator.hasNext())
        {
            ListElem elem = iterator.next();
            System.out.print(elem.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {

        IHashTable hashTable = new IHashTable(10);

        hashTable.insert(1);
        hashTable.insert(11);
        hashTable.insert(2);
        hashTable.insert(32);
        hashTable.insert(42);
        hashTable.insert(3);
        hashTable.insert(3);
        hashTable.insert(33);
        hashTable.insert(4);

        hashTable.print();

        boolean result1 = hashTable.find(3);
        System.out.println("Wynik wyszukiwania 3:" + result1);

        hashTable.delete(3);

        hashTable.print();

        boolean result2 = hashTable.find(3);
        System.out.println("Wynik wyszukiwania 3:" + result2);

    }
}
