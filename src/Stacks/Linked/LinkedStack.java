package Stacks.Linked;
import DinamicStructure.NodeStructure;
import java.lang.reflect.Array;

public class LinkedStack<T> extends NodeStructure<T> {
    private Node<T> head;

    public LinkedStack(){
        super();
        head = null;
    }

    //O(1)
    public void push(T value){
        if (isEmpty()){
            head = new Node<>(value);
            size++;
            return;
        }
        Node<T> newNode = new Node<>(value);
        newNode.setPrevious(head);
        head = newNode;
        size++;
    }

    //O(1)
    public T peek(){
        if (this.isEmpty()) {
            return null;
        }
        return head.getData();
    }

    //O(1)
    public T pop(){
        if(isEmpty()){
            return null;
        }
        Node<T> deleted = head;
        head = head.getPrevious();
        size--;
        return deleted.getData();
    }

    //O(n)
    public int search(T element){
        int counter = 0;
        if (!isEmpty()){
            Node<T> current = head;
            while (current != null){
                if (current.getData().equals(element)){
                    return counter;
                }
                current = current.getPrevious();
                counter++;
            }
        }
        return -1;
    }

    //O(n)
    public boolean contains(T element){
        return search(element) != -1;
    }

    //O(1)
    public void clear() throws RuntimeException {
        if (isEmpty()){
            throw new RuntimeException("Empty Stack");
        }
        head = null;
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(Class<T> clazz) {
        T[] array = (T[]) Array.newInstance(clazz, size);
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            array[index++] = current.getData();
            current = current.getPrevious();
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
            if (current.getPrevious() != null){
                sb.append(", ");
            }
            current = current.getPrevious();
        }
        sb.append("]");
        return sb.toString();
    }
}