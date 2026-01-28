package OptimizationExercises.Stacks.UndoRedo;
import Stack.DinamicArray.StackDinamicArray;
import java.util.NoSuchElementException;

public class UndoRedo<T> extends StackDinamicArray<T> {
    private T currentState;
    private StackDinamicArray<T> undoStack = new StackDinamicArray<>();
    private StackDinamicArray<T>  redoStack = new StackDinamicArray<>();

    public UndoRedo(T initialState){
        super();
        this.currentState = initialState;
    }

    //O(1)
    public void executeAction(T newState){
        undoStack.push(currentState);
        currentState = newState;
        redoStack.clear();
    }

    //O(1)
    public void undo() throws NoSuchElementException {
        if (!canUndo()){
            throw new NoSuchElementException();
        }
        redoStack.push(currentState);
        currentState = undoStack.pop();
    }

    //O(1)
    public void redo() throws NoSuchElementException {
        if (!canRedo()) {
            throw new NoSuchElementException();
        }
        undoStack.push(currentState);
        currentState = redoStack.pop();
    }

    //O(1)
    public T getCurrentState() {
        return currentState;
    }

    //O(1)
    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    //O(1)
    public boolean canRedo() {
        return !redoStack.isEmpty();
    }
}
