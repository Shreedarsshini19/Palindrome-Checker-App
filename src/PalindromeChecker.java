import java.util.Stack;
import java.util.Scanner;
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        PalindromeAlgorithms algo = new PalindromeAlgorithms();
        long start1 = System.nanoTime();
        boolean result1 = algo.twoPointerPalindrome(input);
        long end1 = System.nanoTime();
        long start2 = System.nanoTime();
        boolean result2 = algo.stackPalindrome(input);
        long end2 = System.nanoTime();

        System.out.println("\nTwo Pointer Result: " + result1);
        System.out.println("Execution Time: " + (end1 - start1) + " ns");

        System.out.println("\nStack Method Result: " + result2);
        System.out.println("Execution Time: " + (end2 - start2) + " ns");

        sc.close();
    }
}
class PalindromeAlgorithms {
    public boolean twoPointerPalindrome(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {

            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    // Stack Approach
    public boolean stackPalindrome(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return input.equals(reversed);
    }
}