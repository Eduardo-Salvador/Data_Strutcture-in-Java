package Lists.ArrayList;
import StaticStructure.ArrayStructure;
import java.util.NoSuchElementException;

public class ArrayList<T> extends ArrayStructure<T> {

    public ArrayList(int capacity) {
        super(capacity);
    }

    public ArrayList() {
        super();
    }

    //O(1)
    public T get(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        return this.elements[index];
    }

    //O(1)
    public void set(int index, T element) throws IndexOutOfBoundsException {
        checkIndex(index);
        this.elements[index] = element;
    }

    //O(1) or O(n) If you use the method increaseCapacity
    public void add(T element) {
        super.add(element);
    }

    //O(n)
    public void add(int index, T element) throws IndexOutOfBoundsException {
        super.add(index, element);
    }

    //O(n)
    public T remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        T removed = this.elements[index];
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[--this.size] = null;
        return removed;
    }

    //O(n)
    public boolean remove(T element) {
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    //O(n)
    public T removeFirst() throws NoSuchElementException{
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        T removed = this.elements[0];
        for (int i = 0; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.size--;
        return removed;
    }

    //O(n)
    public T removeLast() throws NoSuchElementException{
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        T removed = this.elements[this.size - 1];
        this.elements[this.size - 1] = null;
        this.size--;
        return removed;
    }

    //O(n)
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    //O(n)
    public int indexOf(T element) {
        if (element == null) {
            for (int i = 0; i < this.size; i++) {
                if (this.elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (element.equals(this.elements[i])) return i;
            }
        }
        return -1;
    }

    //O(n)
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        int i = 0;
        while (i < this.size) {
            newData[i] = this.elements[i];
            i++;
        }
        this.elements = newData;
    }

    //O(1)
    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + this.size
            );
        }
    }
}