/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int idx = 1;
        int f_idx = -1;
        int l_idx = -1;
        int min_dist = Integer.MAX_VALUE;

        ListNode a = head;
        ListNode b = a.next;
        ListNode c = b.next;

        while (c != null) {
            // Check for local minima or local maxima
            if ((b.val < a.val && b.val < c.val) || (b.val > a.val && b.val > c.val)) {
                if (f_idx == -1) {
                    f_idx = idx;
                }
                if (l_idx != -1) {
                    min_dist = Math.min(min_dist, idx - l_idx);
                }
                l_idx = idx;
            }
            
            idx++;
            a = a.next;
            b = b.next;
            c = c.next;
        }

        // If fewer than 2 critical points were found
        if (f_idx == -1 || f_idx == l_idx) {
            return new int[]{-1, -1};
        }

        return new int[]{min_dist, l_idx - f_idx};
    }
}