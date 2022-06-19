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
    int ans = 0;
    int h = 0;
    
    public void help(TreeNode root, int dep){
        if(root == null) return;
        if (h < dep){
            ans = root.val;
            h = dep;
        }
        
        help(root.left, dep+1);
        help(root.right, dep+1);
        
    }
    
    
    public int findBottomLeftValue(TreeNode root) {
        help(root, 1);
        return ans;
    }
}