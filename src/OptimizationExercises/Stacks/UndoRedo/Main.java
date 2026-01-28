package OptimizationExercises.Stacks.UndoRedo;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        UndoRedo<String> editor = new UndoRedo<>("");

        try {
            editor.executeAction("Hello");
            System.out.println(editor.getCurrentState());

            editor.executeAction("Hello World");
            System.out.println(editor.getCurrentState());

            editor.undo();
            System.out.println(editor.getCurrentState());

            editor.redo();
            System.out.println(editor.getCurrentState());

            editor.undo();
            System.out.println(editor.getCurrentState());

            editor.undo();
            System.out.println(editor.getCurrentState());

            editor.redo();
            System.out.println(editor.getCurrentState());

            editor.executeAction("Hi");
            System.out.println(editor.getCurrentState());

            editor.undo();
            System.out.println(editor.getCurrentState());

            editor.undo();
            System.out.println(editor.getCurrentState());

            editor.redo();
            System.out.println(editor.getCurrentState());

            editor.redo();
            System.out.println(editor.getCurrentState());

        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}