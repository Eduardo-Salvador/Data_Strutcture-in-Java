package Arrays;
import StaticStructure.ArrayStructure;

public class Vector <T> extends ArrayStructure<T> {

    public Vector(int capacity) throws IllegalArgumentException {
        super(capacity);
    }

    public Vector(){
        super();
    }

    //O(1)
    public void add(T element) {
        super.add(element);
    }

    //O(n)
    public void add(int index, T element) throws IndexOutOfBoundsException {
        super.add(index, element);
    }

    //O(1)
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        return this.elements[index];
    }

    //O(1)
    public T set(int index, T element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        T oldElement = this.elements[index];
        this.elements[index] = element;
        return oldElement;
    }

    //O(n)
    public T remove(int index) throws IndexOutOfBoundsException {
        if (isEmpty()){
            return null;
        }
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        T elementRemoved = this.elements[index];
        for(int i = index; i < size-1; i++){
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[this.size-1] = null;
        this.size--;
        return elementRemoved;
    }

    //O(n)
    public boolean remove(T element){
        int index = indexOf(element);
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    //O(n)
    public int indexOf(T element){
        for (int i = 0; i < this.size; i++) {
            if (element != null && element.equals(this.elements[i])) {
                return i;
            }
        }
        return -1;
    }

    //O(n)
    public boolean contains(T element){
        return indexOf(element) != -1;
    }

    //O(n), but is possible O(1)
    public void clear(){
        for (int i = 0; i < this.size; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
    }

    //O(1)
    public T getFirst(){
        if (!isEmpty()){
            return this.elements[0];
        }
        return null;
    }

    //O(1)
    public T getLast(){
        if(!isEmpty()){
            return this.elements[this.size-1];
        }
        return null;
    }

    //O(n)
    public int lastIndexOf(T element){
        for (int i = this.size-1; i >= 0; i--) {
            if (element != null && element.equals(this.elements[i])) {
                return i;
            }
        }
        return -1;
    }
}