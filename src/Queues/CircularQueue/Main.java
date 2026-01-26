package Queues.CircularQueue;

public class Main {
    public static void main(String[] args) {
        CircularQueue<Integer> circularQueue = new CircularQueue<>(3);
        circularQueue.list();
        circularQueue.enqueue(10);
        circularQueue.list();
        circularQueue.enqueue(20);
        circularQueue.list();
        try {
            circularQueue.enqueue(30);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Removed: " + circularQueue.dequeue());
        circularQueue.list();
        circularQueue.enqueue(30);
        circularQueue.list();
        System.out.println("Removed: " + circularQueue.dequeue());
        circularQueue.list();
        circularQueue.enqueue(320);
        circularQueue.list();
        System.out.println("Next Element: " + circularQueue.peek());
        System.out.println("Removed: " + circularQueue.dequeue());
        circularQueue.list();
        System.out.println("Size: " + circularQueue.size());
        System.out.println("Exist number 320? " + circularQueue.contains(320));
        System.out.println("Exist number 211? " + circularQueue.contains(211));
        circularQueue.enqueue(302);
        circularQueue.list();
        System.out.println("Cleaning");
        circularQueue.clear();
        circularQueue.list();
    }
}