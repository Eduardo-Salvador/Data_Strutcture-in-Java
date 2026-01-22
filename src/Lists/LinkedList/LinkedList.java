package Lists.LinkedList;
import DinamicStructure.NodeStructure;

import java.lang.reflect.Array;

public class LinkedList<T> extends NodeStructure<T> {
    private Node<T> head;

    public LinkedList() {
        super();
        head = null;
    }

    public void add(int index, T element) {
        checkIndex(index);
        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            size++;
            return;
        }
        Node<T> previous = getNode(index - 1);
        newNode.setNext(previous.getNext());
        previous.setNext(newNode);
        size++;
    }

    public void addFirst(T element){
        Node<T> newNode = new Node<>(element);
        if (isEmpty()){
            head = newNode;
            return;
        }
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void addLast(T element){
        Node<T> newNode =  new Node<>(element);
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
        size++;
    }

    public T get(int index) {
        return getNode(index).getData();
    }

    public T getFirst(){
        if (!isEmpty()){
            return head.getData();
        }
        return null;
    }

    public void set(int index, T element) {
        getNode(index).setData(element);
    }

    public T remove(int index) {
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
        size--;
        return removed.getData();
    }

    public boolean remove(T element) {
        if (isEmpty()){
            return false;
        }
        if (head.getData().equals(element)) {
            head = head.getNext();
            size--;
            return true;
        }
        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(element)) {
                current.setNext(current.getNext().getNext());
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

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

    public void clear() {
        for (Node<T> actual = head; actual != null;){
            Node<T> next =  actual.getNext();
            actual.setData(null);
            actual.setNext(null);
            actual = next;
        }
        head = null;
        size = 0;
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

    private Node<T> getNode(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
    }
}