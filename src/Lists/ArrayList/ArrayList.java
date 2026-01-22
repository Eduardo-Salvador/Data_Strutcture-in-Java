package Lists.ArrayList;
import StaticStructure.ArrayStructure;

public class ArrayList<T> extends ArrayStructure<T> {

    public ArrayList(int capacity) {
        super(capacity);
    }

    public ArrayList() {
        super();
    }

    public T get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public void set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    public void add(T element) {
        super.add(element);
    }

    public void add(int index, T element){
        super.add(index, element);
    }

    public T remove(int index) {
        checkIndex(index);
        T removed = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return removed;
    }

    public boolean remove(T element) {
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public int indexOf(T element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        int i = 0;
        while (i < size) {
            newData[i] = elements[i];
            i++;
        }
        elements = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
    }
}