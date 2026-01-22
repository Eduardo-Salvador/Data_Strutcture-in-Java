package Queues.NormalQueue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(10);
        System.out.println("Is empty? " + queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);
        queue.enqueue(90);
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.contains(30));
        System.out.println(queue.contains(100));
        System.out.println(queue.peek());
        System.out.println("Is full? " + queue.isFull());
        System.out.println("Is empty? " + queue.isEmpty());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.list();
        System.out.println("Is full? " + queue.isFull());
        queue.list();
        queue.clear();
        System.out.println("Is empty? " + queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);
        queue.enqueue(90);
        queue.enqueue(100);
        System.out.println("Is full? " + queue.isFull());
        System.out.println(queue.size());
        queue.enqueue(1);
        System.out.println(queue.size());
    }
}