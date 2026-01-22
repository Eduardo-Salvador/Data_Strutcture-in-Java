package Stack.StaticArray;
import StaticStructure.ArrayStructure;

public class StackStaticArray<T> extends ArrayStructure<T> {
    public StackStaticArray(int capacity){
        super(capacity);
    }

    public StackStaticArray(){
        super();
    }

    public void push(T element) {
        if (isFull()){
            throw new IndexOutOfBoundsException("Full Stack: " + size);
        }
        elements[size] = element;
        this.size++;
    }

    public void push(int index, T element) {
        if (index < 0 || index > size || isFull()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        this.size++;
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
        T popped = elements[size-1];
        elements[size-1] = null;
        this.size--;
        return popped;
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