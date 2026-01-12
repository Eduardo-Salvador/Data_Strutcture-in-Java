package Stack.DinamicArray;

public class Main {
    public static void main(String[] args) {
        StackArray<String> stack = new StackArray<>(5);
        System.out.println("Is empty? " + stack.isEmpty());
        stack.push("Pagina 1");
        stack.push("Pagina 2");
        stack.push("Pagina 3");
        stack.push("Pagina 4");
        stack.push("Pagina 5");
        System.out.println("Is empty? " + stack.isEmpty());
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.search("Pagina 3"));
        stack.push("Pagina 5");
        stack.push("Pagina 6");
        stack.push("Pagina 7");
        stack.push("Pagina 8");
        System.out.println(stack);
        System.out.println(stack.size());
    }
}