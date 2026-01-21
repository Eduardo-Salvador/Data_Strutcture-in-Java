package Stack.StaticArray;
import StaticStructure.StaticStructure;

public class StackArray <T> extends StaticStructure<T> {

    public StackArray(int capacity){
        super(capacity);
    }

    public StackArray(){
        super();
    }

    public void push(T value){
        if(size - 1 == elements.length - 1){
            throw new RuntimeException("Overflow");
        }
        super.add(value);
    }

    public T peek(){
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return elements[size];
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