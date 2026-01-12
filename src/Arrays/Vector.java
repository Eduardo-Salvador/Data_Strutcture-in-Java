package Arrays;

public class Vector <T> {
    private T[] elements;
    private int size;

    public Vector(final int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(T element) {
        increaseCapacity();
        if (size < elements.length) {
            elements[size] = element;
            size++;
        }
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        increaseCapacity();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    private void increaseCapacity(){
        if (size == elements.length) {
            T[] newElements = (T[]) new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    public T set(int index, T element){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    public T remove(int index){
        if (isEmpty()){
            return null;
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T elementRemoved = elements[index];
        for(int i = index; i < size-1; i++){
            elements[i] = elements[i + 1];
        }
        elements[size-1] = null;
        size--;
        return elementRemoved;
    }

    public int indexOf(T element){
        for (int i = 0; i < size; i++) {
            if (element == null && elements[i] == null) {
                return i;
            }
            if (element != null && element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(T element){
        int index = indexOf(element);
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    public int size(){
        return this.size;
    }

    public boolean contains(T element){
        return indexOf(element) != -1;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public T getFirst(){
        if (!isEmpty()){
            return elements[0];
        }
        return null;
    }

    public T getLast(){
        if(!isEmpty()){
            return elements[size-1];
        }
        return null;
    }

    public int lastIndexOf(T element){
        for (int i = size - 1; i > 0; i--) {
            if (element == null && elements[i] == null) {
                return i;
            }
            if (element != null && element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        if (size == 0) return "Vector[]";

        StringBuilder sb = new StringBuilder("Vector[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}