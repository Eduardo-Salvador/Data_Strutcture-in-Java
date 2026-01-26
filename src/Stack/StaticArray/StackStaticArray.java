package Stack.StaticArray;
import StaticStructure.ArrayStructure;

public class StackStaticArray<T> extends ArrayStructure<T> {
    public StackStaticArray(int capacity) throws IllegalArgumentException {
        super(capacity);
    }

    public StackStaticArray(){
        super();
    }

    //O(1)
    public void push(T element) throws IndexOutOfBoundsException {
        if (isFull()){
            throw new IndexOutOfBoundsException("Full Stack: " + this.size);
        }
        this.elements[this.size] = element;
        this.size++;
    }

    //O(1)
    public T peek(){
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
        T popped = this.elements[this.size-1];
        this.elements[this.size-1] = null;
        this.size--;
        return popped;
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
}