package Stack;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Pagina 1");
        stack.push("Pagina 2");
        System.out.println(stack.peek());
    }
}
