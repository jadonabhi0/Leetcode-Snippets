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
    
    static int sum = 0;
    public void helper(TreeNode root, String s){
        if(root == null) return ;
        if(root.left == null && root.right == null){
            s += root.val;
            sum += Integer.parseInt(s,2);
            return ;
        }
        helper(root.left,s+root.val);
        helper(root.right,s+root.val);
    }
    
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        helper(root,"");
        return sum;
    }
}