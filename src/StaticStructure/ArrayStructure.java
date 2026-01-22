package StaticStructure;

public class ArrayStructure<T>{
    protected T[] elements;
    protected int size;

    @SuppressWarnings("unchecked")
    protected ArrayStructure(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException("Initial capacity cannot be negative");
        }
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
    }

    protected ArrayStructure(){
        this(10);
    }

    public boolean isFull(){
        return size == elements.length;
    }

    protected void add(T element) {
        increaseCapacity();
        elements[size] = element;
        this.size++;
    }

    protected void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        increaseCapacity();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    private void increaseCapacity(){
        if (size == elements.length) {
            T[] newElements = (T[]) new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}