public class DListElement {
    Object value;
    public DListElement next;
    public DListElement previous;
    
    public DListElement(Object value){
        this.value = value;
        next = null;
        previous = null;
    }
    
    @Override
    public String toString(){
        return value.toString();
    }
}
