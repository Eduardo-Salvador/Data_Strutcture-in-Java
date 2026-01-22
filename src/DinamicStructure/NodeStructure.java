package DinamicStructure;

public class NodeStructure<T> {
    protected int size;

    protected NodeStructure(){
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
}