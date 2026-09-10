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
  private int matchingNodeCount = 0;

    public int averageOfSubtree(TreeNode root) {
        matchingNodeCount = 0;
        postOrder(root);
        return matchingNodeCount;
    }

    // Returns an array: index 0 = subtree sum, index 1 = subtree node count
    private int[] postOrder(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        // Recursively get stats from left and right subtrees
        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        int currentSum = node.val + left[0] + right[0];
        int currentCount = 1 + left[1] + right[1];

        // Check if the floor average equals the node value
        if (currentSum / currentCount == node.val) {
            matchingNodeCount++;
        }

        return new int[]{currentSum, currentCount};
    }
}