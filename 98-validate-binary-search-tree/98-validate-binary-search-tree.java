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
    public static long max(TreeNode root){
        if(root == null) return Long.MIN_VALUE;
        long m = max(root.right);
        return Math.max(m,root.val);
    }
    
     public static long min(TreeNode root){
        if(root == null) return Long.MAX_VALUE;
        long m = min(root.left);
        return Math.min(m,root.val);
    }
    
    
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);
        long max = max(root.left);
        long min = min(root.right);
        if(left && right &&(max < root.val && min > root.val)) return true;
        return false;
    }
}