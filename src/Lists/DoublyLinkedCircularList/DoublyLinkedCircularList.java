package Lists.DoublyLinkedCircularList;
import DinamicStructure.NodeStructure;
import java.lang.reflect.Array;

public class DoublyLinkedCircularList<T> extends NodeStructure<T> {
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedCircularList(){
        super();
        head = null;
    }

    //O(n)
    public void add(int index, T element) throws IndexOutOfBoundsException {
        checkIndex(index);
        Node<T> newNode = new Node<>(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
            this.size++;
            return;
        }

        if (index == 0) {
            newNode.setNext(head);
            newNode.setPrevious(tail);
            head.setPrevious(newNode);
            head = newNode;
            tail.setNext(head);
            this.size++;
            return;
        }

        if (index == this.size) {
            newNode.setNext(head);
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
            this.size++;
            return;
        }

        Node<T> previous = getNode(index - 1);
        newNode.setNext(previous.getNext());
        previous.getNext().setPrevious(newNode);
        newNode.setPrevious(previous);
        previous.setNext(newNode);
        this.size++;
    }

    //O(1)
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
        } else {
            newNode.setNext(head);
            newNode.setPrevious(tail);
            head.setPrevious(newNode);
            head = newNode;
            tail.setNext(head);
        }
        this.size++;
    }

    //O(1)
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
        } else {
            newNode.setNext(head);
            newNode.setPrevious(tail);
            head.setPrevious(newNode);
            tail.setNext(newNode);
            tail = newNode;
        }
        this.size++;
    }

    //O(n)
    public T get(int index) throws IndexOutOfBoundsException {
        return getNode(index).getData();
    }

    //O(1)
    public T getFirst(){
        if (!isEmpty()){
            return head.getData();
        }
        return null;
    }

    //O(n)
    public void set(int index, T element) throws IndexOutOfBoundsException {
        getNode(index).setData(element);
    }

    //O(1)
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> removed = head;
        if (this.size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(tail);
            tail.setNext(head);
        }
        this.size--;
        return removed.getData();
    }

    //O(1)
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node<T> removed = tail;

        if (this.size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrevious();
            head.setPrevious(tail);
            tail.setNext(head);
        }
        this.size--;
        return removed.getData();
    }

    //O(1)
    public T remove(int index) {
        checkIndex(index);

        Node<T> removed;

        if (this.size == 1) {
            removed = head;
            head = null;
            tail = null;
            this.size--;
            return removed.getData();
        }

        if (index == this.size - 1) {
            return removeLast();
        }

        if (index == 0) {
            return removeFirst();
        }

        Node<T> previous = getNode(index - 1);
        removed = previous.getNext();
        previous.setNext(removed.getNext());
        removed.getNext().setPrevious(previous);

        this.size--;
        return removed.getData();
    }

    //O(n)
    public boolean remove(T element) {
        if (isEmpty()) {
            return false;
        }

        if (this.size == 1) {
            if (head.getData().equals(element)) {
                head = null;
                tail = null;
                this.size--;
                return true;
            }
            return false;
        }

        if (head.getData().equals(element)) {
            removeFirst();
            return true;
        }

        Node<T> current = head;
        do {
            Node<T> next = current.getNext();
            if (next.getData().equals(element)) {
                current.setNext(next.getNext());
                next.getNext().setPrevious(current);
                if (next == tail) {
                    tail = current;
                    tail.setNext(head);
                }
                this.size--;
                return true;
            }
            current = current.getNext();
        } while (current != head);

        return false;
    }

    //O(n)
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    //O(n)
    public int indexOf(T element) {
        if (isEmpty()) return -1;

        Node<T> current = head;
        int index = 0;

        do {
            if (current.getData().equals(element)) {
                return index;
            }
            current = current.getNext();
            index++;
        } while (current != head);

        return -1;
    }

    // O(1)
    public void clear() {
        head = null;
        tail = null;
        this.size = 0;
    }

    //O(n)
    @SuppressWarnings("unchecked")
    public T[] toArray(Class<T> clazz) {
        if (isEmpty()) return null;

        T[] array = (T[]) Array.newInstance(clazz, this.size);

        Node<T> current = head;
        int i = 0;

        do {
            array[i++] = current.getData();
            current = current.getNext();
        } while (current != head);

        return array;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;

        do {
            sb.append(current.getData());
            current = current.getNext();
            if (current != head) {
                sb.append(", ");
            }
        } while (current != head);

        sb.append("]");
        return sb.toString();
    }

    //O(n)
    private Node<T> getNode(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    //O(1)
    private void checkIndex(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
    }
}