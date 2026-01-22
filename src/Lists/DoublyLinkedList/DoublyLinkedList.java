package Lists.DoublyLinkedList;
import java.lang.reflect.Array;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> last;
    private int size;

    public DoublyLinkedList(){
        head = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size - 1;
    }

    public boolean add(T element){
        Node<T> newNode = new Node<>(element);
        if (isEmpty()){
            head = newNode;
            size++;
            return true;
        }
        Node<T> current = head;
        while (current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(newNode);
        newNode.setPrevious(current);
        last = newNode;
        size++;
        return true;
    }

    public void add(int index, T element){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index OutOfBound");
        }

        Node<T> newNode = new Node<>(element);

        if (index == 0) {
            if (isEmpty()) {
                head = newNode;
                size++;
                return;
            }
            addFirst(element);
            size++;
            return;
        }

        Node<T> current = head;
        if (index == size){
            last = newNode;
        }
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        newNode.setPrevious(current);
        if (current.getNext() != null){
            current.getNext().setPrevious(newNode);
        }
        current.setNext(newNode);
        size++;
    }

    public void addFirst(T element){
        Node<T> newNode = new Node<>(element);
        if (isEmpty()){
            head = newNode;
            size++;
        }
        head.setPrevious(newNode);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void addLast(T element){
        Node<T> newNode = new Node<>(element);
        last = newNode;
        if (isEmpty()){
            head = newNode;
            size++;
            return;
        }
        Node<T> current = head;
        while (current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(newNode);
        newNode.setPrevious(current);
        size++;
    }

    public T remove(){
        if (isEmpty()){
            throw new NullPointerException("Linked list is empty");
        }
        Node<T> removed = head;
        head = head.getNext();
        head.setPrevious(null);
        size--;
        return removed.getData();
    }

    public T remove(int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index OutOfBound");
        }

        Node<T> removed;

        if (index == 0) {
            removed = head;
            head = null;
            size--;
            return removed.getData();
        }
        if (index == size){
            last = last.getPrevious();
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        current.getNext().setPrevious(current.getPrevious());
        current.getPrevious().setNext(current.getNext());
        removed = current;
        current = null;
        size--;
        return removed.getData();
    }

    public boolean remove(T element){
        if (isEmpty()){
            throw new NullPointerException("Linked list is empty");
        }
        Node<T> current = head;
        int i = 0;
        while(current.getNext() != null){
            if (current.getData().equals(element)){
                current.getNext().setPrevious(current.getPrevious());
                current.getPrevious().setNext(current.getNext());
                current = null;
                if (i == size){
                    last = last.getPrevious();
                    last.setNext(null);
                }
                size--;
                return true;
            }
            current = current.getNext();
            i++;
        }
        current = null;
        last = last.getPrevious();
        last.setNext(null);
        size--;
        return true;
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        Node<T> removed = head;
        head = head.getNext();
        size--;
        return removed.getData();
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        Node<T> removed = last;
        last = last.getPrevious();
        last.setNext(null);
        size--;
        return removed.getData();
    }

    public boolean removeFirstOccurrence(T element){
        if (isEmpty()){
            throw new NullPointerException("Linked list is empty");
        }
        Node<T> current = head;
        while(current.getNext() != null){
            if (current.getData().equals(element)){
                current.getNext().setPrevious(current.getPrevious());
                current.getPrevious().setNext(current.getNext());
                current = null;
                size--;
                return true;
            }
            current = current.getNext();
        }
        current = null;
        size--;
        return true;
    }

    public boolean removeLastOccurrence(T element){
        if (isEmpty()){
            throw new NullPointerException("Linked list is empty");
        }
        if (last.getData().equals(element)){
            last = last.getPrevious();
            last.setNext(null);
            size--;
            return true;
        }
        Node<T> current = last;
        while(current.getPrevious() != null){
            if (current.getData().equals(element)){
                current.getNext().setPrevious(current.getPrevious());
                current.getPrevious().setNext(current.getNext());
                current = null;
                size--;
                return true;
            }
            current = current.getPrevious();
        }
        current = null;
        size--;
        return true;
    }

    public T get(int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index OutOfBound");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public T getFirst(){
        if (isEmpty()) {
            throw new NullPointerException("Empty List");
        }
        return head.getData();
    }

    public T getLast(){
        if (isEmpty()) {
            throw new NullPointerException("Empty List");
        }
        return last.getData();
    }

    public boolean contains(T element){
        if (isEmpty()){
            return false;
        }
        Node<T> current = head;
        while(current.getNext() != null){
            if (current.getData().equals(element)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int indexOf(T element){
        if (isEmpty()){
            return -1;
        }
        int index = 0;
        Node<T> current = head;
        while(current.getNext() != null){
            if (current.getData().equals(element)){
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public int lastIndexOf(T element){
        if (isEmpty()){
            return -1;
        }

        int index = size - 1;
        Node<T> current = last;

        while (current != null){
            if (current.getData().equals(element)){
                return index;
            }
            current = current.getPrevious();
            index--;
        }

        return -1;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(Class<T> clazz){
        if (isEmpty()){
            return null;
        }
        T[] array = (T[]) Array.newInstance(clazz, size);
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
}