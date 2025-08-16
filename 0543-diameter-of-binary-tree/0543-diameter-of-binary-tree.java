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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int d1 = maxDepth(root.left) + maxDepth(root.right);
        int d2 = diameterOfBinaryTree(root.left);
        int d3 = diameterOfBinaryTree(root.right);
        return Math.max(d3, Math.max(d1, d2));
    }


    private int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left)+1, maxDepth(root.right) + 1);
    }

}