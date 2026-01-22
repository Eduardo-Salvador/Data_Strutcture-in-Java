package Stack.StaticArray;

public class Main {
    public static void main(String[] args) {
        StackStaticArray<String> stack = new StackStaticArray<>(5);
        System.out.println("Is empty? " + stack.isEmpty());
        stack.push("Pagina 1");
        stack.push("Pagina 2");
        stack.push("Pagina 3");
        stack.push(2, "Pagina 4");
        stack.push("Pagina 5");
        System.out.println("Is empty? " + stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.search("Pagina 3"));
        stack.push("Pagina 5");
        System.out.println(stack);
        try {
            stack.push("Pagina 6");
            stack.push("Pagina 7");
            stack.push("Pagina 8");
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println(stack.size());
    }
}