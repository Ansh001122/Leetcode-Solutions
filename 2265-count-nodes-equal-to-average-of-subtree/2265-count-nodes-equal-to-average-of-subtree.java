/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
 class Pair {
        int sum, c;
        Pair(int sum, int c) {
            this.sum = sum;
            this.c = c;
        }
    }

    private int count = 0;

    public int averageOfSubtree(TreeNode root) {
        count = 0; // Reset for repeated test calls
        d(root);
        return count;
    }

    private Pair d(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair p1 = d(root.left);
        Pair p2 = d(root.right);

        int sum = p1.sum + p2.sum + root.val;
        int c = p1.c + p2.c + 1;

        if (sum / c == root.val) {
            count++;
        }

        return new Pair(sum, c);
    }
}