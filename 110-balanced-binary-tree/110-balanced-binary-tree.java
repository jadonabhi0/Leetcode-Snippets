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
    
    // static class BalancePair{
    //     int ht = -1;
    //     boolean isbal = true;
    // }
    
    public static boolean isbal = true;
    public int helper(TreeNode root){
//         if(root == null) return new BalancePair();
        
//         BalancePair lh = helper(root.left);
//         BalancePair rh = helper(root.right);
//         BalancePair sb = new BalancePair();
//         sb.ht = Math.max(lh.ht,rh.ht)+1;
//         boolean gap = Math.abs(lh.ht - rh.ht) <= 1;
//         sb.isbal = gap && lh.isbal && rh.isbal;
//         return sb;
        
        if(root  == null) return 0;
        
        int lh = helper(root.left);
        int rh = helper(root.right);
        
        int th = Math.max(lh,rh)+1;
        
        int gap = Math.abs(lh - rh);
        
        if(gap > 1){
            isbal = false;
        }
        
        return th;
    }
    
    
    public boolean isBalanced(TreeNode root) {
        isbal = true;
        if(root == null) return true;
        helper(root);
        return isbal;
    }
}