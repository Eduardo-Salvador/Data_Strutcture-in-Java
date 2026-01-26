package Lists.DoublyLinkedList;
import DinamicStructure.NodeStructure;
import java.lang.reflect.Array;

public class DoublyLinkedList<T> extends NodeStructure<T> {
    private Node<T> head;
    private Node<T> last;

    public DoublyLinkedList(){
        head = null;
        last = null;
        size = 0;
    }

    //O(1)
    public boolean isEmpty() {
        return head == null;
    }

    //O(1)
    public int size() {
        if (this.size == 0) {
            return 0;
        }
        return this.size - 1;
    }

    //O(1)
    public boolean add(T element){
        Node<T> newNode = new Node<>(element);
        if (isEmpty()){
            head = newNode;
            last = newNode;
            this.size++;
            return true;
        }
        last.setNext(newNode);
        newNode.setPrevious(last);
        last = newNode;
        this.size++;
        return true;
    }

    //O(n)
    public void add(int index, T element) throws IndexOutOfBoundsException{
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index OutOfBound");
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == this.size){
            addLast(element);
            return;
        }

        Node<T> newNode = new Node<>(element);
        Node<T> current;
        if (index <= this.size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = last;
            for (int i = this.size - 1; i > index; i--) {
                current = current.getPrevious();
            }
        }

        newNode.setNext(current);
        newNode.setPrevious(current.getPrevious());
        current.getPrevious().setNext(newNode);
        current.setPrevious(newNode);

        this.size++;
    }

    //O(1)
    public void addFirst(T element){
        Node<T> newNode = new Node<>(element);
        if (isEmpty()){
            head = newNode;
            last = newNode;
            this.size++;
        }
        head.setPrevious(newNode);
        newNode.setNext(head);
        head = newNode;
        this.size++;
    }

    //O(1)
    public void addLast(T element){
        add(element);
    }

    //O(1)
    public T remove(){
        if (isEmpty()){
            return null;
        }
        Node<T> removed = head;
        head = head.getNext();
        head.setPrevious(null);
        this.size--;
        return removed.getData();
    }

    //O(n)
    public T remove(int index) throws IndexOutOfBoundsException{
        Node<T> removed;
        if (index < 0 || index > (size - 1)) {
            throw new IndexOutOfBoundsException("Index OutOfBound");
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == (this.size - 1)){
            return removeLast();
        }

        Node<T> current;
        if (index <= this.size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = last;
            for (int i = this.size - 1; i > index; i--) {
                current = current.getPrevious();
            }
        }
        current.getNext().setPrevious(current.getPrevious());
        current.getPrevious().setNext(current.getNext());
        removed = current;
        this.size--;
        return removed.getData();
    }

    //O(n)
    public boolean remove(T element) throws NullPointerException{
        if (isEmpty()){
            throw new NullPointerException("Linked list is empty");
        }
        Node<T> current = head;
        int i = 0;
        while(current.getNext() != null){
            if (current.getData().equals(element)){
                current.getNext().setPrevious(current.getPrevious());
                current.getPrevious().setNext(current.getNext());
                if (i == this.size){
                    last = last.getPrevious();
                    last.setNext(null);
                }
                this.size--;
                return true;
            }
            current = current.getNext();
            i++;
        }
        last = last.getPrevious();
        last.setNext(null);
        this.size--;
        return true;
    }

    //O(1)
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        Node<T> removed = head;
        head = head.getNext();
        head.setPrevious(null);
        this.size--;
        return removed.getData();
    }

    //O(1)
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        Node<T> removed = last;
        last = last.getPrevious();
        last.setNext(null);
        this.size--;
        return removed.getData();
    }

    //O(n)
    public boolean removeFirstOccurrence(T element) throws NullPointerException{
        if (isEmpty()){
            throw new NullPointerException("Linked list is empty");
        }
        Node<T> current = head;
        while(current.getNext() != null){
            if (current.getData().equals(element)){
                current.getNext().setPrevious(current.getPrevious());
                current.getPrevious().setNext(current.getNext());
                this.size--;
                return true;
            }
            current = current.getNext();
        }
        this.size--;
        return true;
    }

    //O(n)
    public boolean removeLastOccurrence(T element) throws NullPointerException{
        if (isEmpty()){
            throw new NullPointerException("Linked list is empty");
        }
        if (last.getData().equals(element)){
            last = last.getPrevious();
            last.setNext(null);
            this.size--;
            return true;
        }
        Node<T> current = last;
        while(current.getPrevious() != null){
            if (current.getData().equals(element)){
                current.getNext().setPrevious(current.getPrevious());
                current.getPrevious().setNext(current.getNext());
                this.size--;
                return true;
            }
            current = current.getPrevious();
        }
        this.size--;
        return true;
    }

    //O(1)
    public void clear(){
        head = null;
        last = null;
        this.size = 0;
    }

    //O(n)
    public T get(int index){
        if (index < 0 || index > this.size) {
            return null;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    //O(1)
    public T getFirst() throws NullPointerException{
        if (isEmpty()) {
            throw new NullPointerException("Empty List");
        }
        return head.getData();
    }

    //O(1)
    public T getLast() throws NullPointerException{
        if (isEmpty()) {
            throw new NullPointerException("Empty List");
        }
        return last.getData();
    }

    //O(n)
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

    //O(n)
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

    //O(n)
    public int lastIndexOf(T element){
        if (isEmpty()){
            return -1;
        }

        int index = this.size - 1;
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
}