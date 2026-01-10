package Queue;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        fila.offer("Client 1");
        fila.offer("Client 2");
        System.out.println(fila.peek());
        System.out.println(fila.poll());
    }
}
