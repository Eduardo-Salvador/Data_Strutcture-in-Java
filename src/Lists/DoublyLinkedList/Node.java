package Lists.DoublyLinkedList;

public class Node<T> {
    T data;
    Node next;
    Node previous;

    Node(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}