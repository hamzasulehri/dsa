package dsa.linked_lists.optimal;

/*
Problem: Linked List Cycle
Approach: Optimal
Floyd's Cycle Detection (fast/slow pointers). Slow moves 1 step, fast
moves 2 steps. If there's a cycle, fast will eventually lap slow and
they will meet; if not, fast reaches null first.
Time Complexity: O(n)
Space Complexity: O(1)
*/
public class LinkedListCycleOptimal {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // build list: 3 -> 2 -> 0 -> -4 -> (back to node with val 2)
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // creates a cycle

        System.out.println(hasCycle(head)); // expected: true
    }
}
