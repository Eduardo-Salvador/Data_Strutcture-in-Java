package OptimizationExercises.Queues.QueueWith2Stacks;

public class Main {
    public static void main(String[] args) {
        QueueWith2Stacks<Integer> queueWith2Stacks = new QueueWith2Stacks<>();
        queueWith2Stacks.enqueue(10);
        queueWith2Stacks.enqueue(34);
        queueWith2Stacks.enqueue(32);
        queueWith2Stacks.enqueue(12);
        queueWith2Stacks.enqueue(56);
        queueWith2Stacks.enqueue(3);
        queueWith2Stacks.enqueue(321);
        queueWith2Stacks.enqueue(49);
        queueWith2Stacks.enqueue(23);

        System.out.println(queueWith2Stacks.getMax());
        System.out.println(queueWith2Stacks.getMin());
        System.out.println(queueWith2Stacks.dequeue());
        System.out.println(queueWith2Stacks.dequeue());
        System.out.println(queueWith2Stacks.dequeue());
    }
}