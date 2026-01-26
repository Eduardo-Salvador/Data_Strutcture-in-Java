package Lists.LinkedList;
import DinamicStructure.NodeStructure;
import java.lang.reflect.Array;

public class LinkedList<T> extends NodeStructure<T> {
    private Node<T> head;

    public LinkedList() {
        super();
        head = null;
    }

    //O(n)
    public void add(int index, T element) throws IndexOutOfBoundsException {
        checkIndex(index);
        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            this.size++;
            return;
        }
        Node<T> previous = getNode(index - 1);
        newNode.setNext(previous.getNext());
        previous.setNext(newNode);
        this.size++;
    }

    //O(1)
    public void addFirst(T element){
        Node<T> newNode = new Node<>(element);
        if (isEmpty()){
            head = newNode;
            return;
        }
        newNode.setNext(head);
        head = newNode;
        this.size++;
    }

    //O(n)
    public void addLast(T element){
        Node<T> newNode =  new Node<>(element);
        if (isEmpty()){
            head = newNode;
            this.size++;
            return;
        }
        Node<T> current = head;
        while (current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(newNode);
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

    //O(n)
    public T remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        Node<T> removed;
        if (index == 0) {
            removed = head;
            head = head.getNext();
        } else {
            Node<T> previous = getNode(index - 1);
            removed = previous.getNext();
            previous.setNext(removed.getNext());
        }
        this.size--;
        return removed.getData();
    }

    //O(n)
    public boolean remove(T element) {
        if (isEmpty()){
            return false;
        }
        if (head.getData().equals(element)) {
            head = head.getNext();
            this.size--;
            return true;
        }
        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(element)) {
                current.setNext(current.getNext().getNext());
                this.size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    //O(n)
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    //O(n)
    public int indexOf(T element) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.getData().equals(element)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    //O(1)
    public void clear() {
        head = null;
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(Class<T> clazz){
        if (isEmpty()){
            return null;
        }
        T[] array = (T[]) Array.newInstance(clazz, this.size);
        Node<T> current = head;
        int i = 0;
        while (current != null){
            array[i] = current.getData();
            current = current.getNext();
            i++;
        }
        return array;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;

        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null){
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    //O(n)
    private Node<T> getNode(int index) throws IndexOutOfBoundsException{
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    //O(1)
    private void checkIndex(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + this.size
            );
        }
    }
}