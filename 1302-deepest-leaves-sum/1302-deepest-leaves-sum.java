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
    int sum = 0;
    int lev = 0;
    int mlev = 0;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        sum(root, 0);
        return sum;
    }
    
    
    public void sum(TreeNode root, int lev){
        if(root == null) return;
        if(lev > mlev){
            mlev = lev;
            sum = 0;
        }
        if(lev == mlev){
            sum += root.val;
        }
        
        sum(root.left, lev+1);
        sum(root.right, lev+1);
    }
}