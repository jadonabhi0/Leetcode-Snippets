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
    
    static class BalancePair{
        int ht = -1;
        boolean isbal = true ;
    }

    private static BalancePair isBalance(TreeNode root){
        if (root == null) return  new BalancePair();

        BalancePair lbp = isBalance(root.left);
        BalancePair rbp = isBalance(root.right);
        BalancePair sbp = new BalancePair();
        sbp.ht = Math.max(lbp.ht , rbp.ht) +1;
        boolean sb = Math.abs(lbp.ht - rbp.ht) <= 1;
        sbp.isbal = sb && lbp.isbal && rbp.isbal;
        return sbp;
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        return isBalance(root).isbal;
    }
}