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
    int ans = 0 ;
    public int goodNodes(TreeNode root) {
        return cntGoodNodes(root, Integer.MIN_VALUE);
    }

    private int cntGoodNodes(TreeNode root, int maxSoFar){

        if(root == null) return 0;

        int good = 0;
        if(root.val >= maxSoFar){
            good = 1;
        }

        int newMax = Math.max(maxSoFar, root.val);
        int l = cntGoodNodes(root.left, newMax);
        int r = cntGoodNodes(root.right, newMax);

        return l + r + good;
    }
}