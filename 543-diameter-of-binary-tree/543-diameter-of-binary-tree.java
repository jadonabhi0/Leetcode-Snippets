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
    static int height(TreeNode root){
        if(root == null) return 0;
        int a = height(root.left);
        int b = height(root.right);
        int c = Math.max(a,b);
        return c+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int d1 = diameterOfBinaryTree(root.left);
        int d2 = diameterOfBinaryTree(root.right);
        int d3 = height(root.left) + height(root.right) ;
        return Math.max(Math.max(d1, d2), d3);
    }
}