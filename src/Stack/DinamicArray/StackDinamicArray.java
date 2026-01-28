package Stack.DinamicArray;
import StaticStructure.ArrayStructure;

public class StackDinamicArray<T> extends ArrayStructure<T> {
    public StackDinamicArray(int capacity){
        super(capacity);
    }

    public StackDinamicArray(){
        super();
    }

    //O(1) or O(n) If you use the method increaseCapacity
    public void push(T value){
        super.add(value);
    }

    //O(1)
    public T peek() throws RuntimeException{
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return this.elements[this.size-1];
    }

    //O(1)
    public T pop(){
        if(isEmpty()){
            return null;
        }
        return this.elements[--this.size];
    }

    //O(n)
    public int search(T element){
        if (!isEmpty()){
            for (int i = 0; i < this.elements.length; i++) {
                if (this.elements[i].equals(element)){
                    return (this.size-1) - i + 1;
                }
            }
        }
        return -1;
    }

    //O(1)
    public void clear(){
        this.size = 0;
    }
}