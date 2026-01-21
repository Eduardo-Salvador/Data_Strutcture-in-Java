package Queues.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(10);
        System.out.println("Is empty? " + priorityQueue.isEmpty());
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(50);
        priorityQueue.enqueue(60);
        priorityQueue.enqueue(70);
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(20);
        priorityQueue.enqueue(30);
        priorityQueue.enqueue(80);
        priorityQueue.enqueue(90);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.contains(30));
        System.out.println(priorityQueue.contains(100));
        System.out.println(priorityQueue.peek());
        System.out.println("Is full? " + priorityQueue.isFull());
        System.out.println("Is empty? " + priorityQueue.isEmpty());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        priorityQueue.list();
        System.out.println("Is full? " + priorityQueue.isFull());
        priorityQueue.list();
        priorityQueue.clear();
        System.out.println("Is empty? " + priorityQueue.isEmpty());
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(70);
        priorityQueue.enqueue(80);
        priorityQueue.enqueue(90);
        priorityQueue.enqueue(100);
        priorityQueue.enqueue(40);
        priorityQueue.enqueue(50);
        priorityQueue.enqueue(60);
        priorityQueue.enqueue(20);
        priorityQueue.enqueue(30);

        System.out.println("Is full? " + priorityQueue.isFull());
        System.out.println(priorityQueue.size());
        priorityQueue.enqueue(1);
        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
    }
}