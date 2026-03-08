import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class UseCase6PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "noon";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            queue.add(c);  // FIFO
            stack.push(c); // LIFO
        }
        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            char fromQueue = queue.remove();
            char fromStack = stack.pop();

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("The word \"" + word + "\" is a palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a palindrome.");
        }

        System.out.println("Program finished.");
    }
}