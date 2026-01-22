package Arrays;
import StaticStructure.ArrayStructure;

public class Vector <T> extends ArrayStructure<T> {

    public Vector(int capacity) {
        super(capacity);
    }

    public Vector(){
        super();
    }

    public void add(T element) {
        super.add(element);
    }

    public void add(int index, T element) {
        super.add(index, element);
    }

    public T get(int index){
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        return elements[index];
    }

    public T set(int index, T element){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
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

    public boolean remove(T element){
        int index = indexOf(element);
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    public int indexOf(T element){
        for (int i = 0; i < size; i++) {
            if (element != null && element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
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
        for (int i = size-1; i >= 0; i--) {
            if (element != null && element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }
}