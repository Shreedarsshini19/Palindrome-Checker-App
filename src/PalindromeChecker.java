public class PalindromeChecker {
    public static void main(String[] args) {
        String word = "level";
        char[] chars = word.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        if (isPalindrome) {
            System.out.println("The word \"" + word + "\" is a palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a palindrome.");
        }
        System.out.println("Program finished.");
    }
}