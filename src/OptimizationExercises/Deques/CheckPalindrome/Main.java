package OptimizationExercises.Deques.CheckPalindrome;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean result = CheckPalindrome.isPalindrome("Level");
        System.out.println("Is palindrome? " + result);

        result = CheckPalindrome.isPalindrome("a");
        System.out.println("Is palindrome? " + result);

        result = CheckPalindrome.isPalindrome("a man a plan a canal panama");
        System.out.println("Is palindrome? " + result);

        result = CheckPalindrome.isPalindrome("palindrome");
        System.out.println("Is palindrome? " + result);

        Scanner input = new Scanner(System.in);

        System.out.println("Palindrome test, enter a word: ");
        String word = input.nextLine();
        result = CheckPalindrome.isPalindrome(word);
        System.out.println("Is palindrome? " + result);
    }
}