public class ListElem {

    public int iData;
    public ListElem next;

    public ListElem(int iData)
    {
        this.iData = iData;
        next = null;
    }

    @Override
    public String toString() {
        return Integer.toString(iData);
    }
}
