/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) { // if there is null that means that linked list doesn't have any cycle and if it continues then you know the rest function.
            slow = slow.next;           // One step
            fast = fast.next.next;      // Two steps

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}