package OptimizationExercises.Deques.CheckPalindrome;
import Deque.LinkedListDeque.DoublyLinkedListDeque;

public class CheckPalindrome extends DoublyLinkedListDeque<Character> {

    public CheckPalindrome(){
        super();
    }

    //O(n), but the add and remove deque: O(1)
    public static boolean isPalindrome(String word){
        DoublyLinkedListDeque<Character> palindrome = new DoublyLinkedListDeque<>();
        if (word != null){
            for (Character c : word.toLowerCase().toCharArray()) {
                if (c == ' ') {
                    continue;
                }
                palindrome.addLast(c);
            }
            while (palindrome.size() > 1){
                if (!palindrome.getFirst().equals(palindrome.getLast())){
                    return false;
                }
                palindrome.removeFirst();
                palindrome.removeLast();
            }
        }
        return true;
    }
}