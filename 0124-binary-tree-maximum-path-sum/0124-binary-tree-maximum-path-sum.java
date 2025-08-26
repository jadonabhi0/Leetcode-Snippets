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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
         findMaxSum(root);
         return maxSum;
    }


    private int findMaxSum(TreeNode root){
        if(root == null) return 0;

        int lSum = Math.max(0, findMaxSum(root.left));
        int rSum = Math.max(0, findMaxSum(root.right));

        maxSum = Math.max(lSum + rSum + root.val, maxSum);

        return Math.max(lSum, rSum) + root.val;
    }

}