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
    public boolean isValidBST(TreeNode root) {
        return checkValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkValidBST(TreeNode root, Long lmin, Long rmax) {

        if(root == null) return true;

        if (root.val <= lmin || root.val >= rmax) return false;

        boolean a = checkValidBST(root.left, lmin, (long)root.val);
        boolean b = checkValidBST(root.right, (long)root.val, rmax);

        if(!a || !b) return false;

        return a & b;
    }

}