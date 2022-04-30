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
     
    public int minDepth(TreeNode root) {
      
        if(root == null) return 0;
        
        if(root.left == null && root.right == null){
            return 1;
        }
        
        int a = minDepth(root.left);
        a = a > 0 ? a : Integer.MAX_VALUE;
        int b = minDepth(root.right);
        b = b > 0 ? b : Integer.MAX_VALUE;
        return Math.min(a,b)+1;
        
    }
}