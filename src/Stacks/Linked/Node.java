package Stacks.Linked;

public class Node<T> {
    private T data;
    private Node<T> previous;

    public Node(T data){
        this.data = data;
        previous = null;
    }

    public Node(T data, Node<T> previous) {
        this.data = data;
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", previous=" + previous +
                '}';
    }
}