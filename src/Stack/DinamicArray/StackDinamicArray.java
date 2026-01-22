package Stack.DinamicArray;
import StaticStructure.ArrayStructure;

public class StackDinamicArray<T> extends ArrayStructure<T> {
    public StackDinamicArray(int capacity){
        super(capacity);
    }

    public StackDinamicArray(){
        super();
    }

    public void push(T value){
        super.add(value);
    }

    public T peek(){
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return elements[size-1];
    }

    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("Underflow");
        }
        return elements[--size];
    }

    public int search(T element){
        if (!isEmpty()){
            for (int i = 0; i < elements.length; i++) {
                if (elements[i].equals(element)){
                    return (size-1) - i + 1;
                }
            }
        }
        return -1;
    }
}