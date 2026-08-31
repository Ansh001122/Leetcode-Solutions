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

        int firstCritical = -1;
        int prevCritical = -1;
        int minDistance = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;
        int index = 2; // curr is at 1-based index 2

        while (curr.next != null) {
            ListNode next = curr.next;

            // Check if curr is a local minima or local maxima
            boolean isLocalMax = (curr.val > prev.val && curr.val > next.val);
            boolean isLocalMin = (curr.val < prev.val && curr.val < next.val);

            if (isLocalMax || isLocalMin) {
                if (firstCritical == -1) {
                    firstCritical = index;
                } else {
                    // Update minDistance with the distance to the immediately preceding critical point
                    minDistance = Math.min(minDistance, index - prevCritical);
                }
                prevCritical = index;
            }

            prev = curr;
            curr = next;
            index++;
        }

        // If fewer than 2 critical points were found
        if (firstCritical == -1 || firstCritical == prevCritical) {
            return new int[]{-1, -1};
        }

        int maxDistance = prevCritical - firstCritical;
        return new int[]{minDistance, maxDistance};
    }
}