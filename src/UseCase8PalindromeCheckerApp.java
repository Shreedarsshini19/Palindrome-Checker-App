public class UseCase8PalindromeCheckerApp {
    static class Node {
        char data;
        Node next;
        Node(char data) { this.data = data; }
    }
    public static void main(String[] args) {
        String word = "level";
        Node head = buildLinkedList(word);
        boolean isPalindrome = checkPalindrome(head);
        if (isPalindrome) {
            System.out.println("The word \"" + word + "\" is a palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a palindrome.");
        }
        System.out.println("Program finished.");
    }
    private static Node buildLinkedList(String word) {
        Node head = null;
        Node tail = null;
        for (char c : word.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }
    private static boolean checkPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = reverseList(slow.next);
        Node firstHalf = head;
        Node temp = secondHalf;
        boolean isPalindrome = true;
        while (temp != null) {
            if (firstHalf.data != temp.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }
        slow.next = reverseList(secondHalf);

        return isPalindrome;
    }
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }
}
