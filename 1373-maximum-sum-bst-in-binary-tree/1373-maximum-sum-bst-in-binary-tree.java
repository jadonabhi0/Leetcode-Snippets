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

class Pair {
    int sum;
    int leftMax;
    int rightMin;
    boolean isBst;

    Pair() {
        this.sum = 0;
        this.leftMax = Integer.MIN_VALUE;
        this.rightMin = Integer.MAX_VALUE;
        this.isBst = true; 
    }

    
}

class Solution {
    int ans;
    public int maxSumBST(TreeNode root) {
        ans = Integer.MIN_VALUE;
        helper(root);
        return ans < 0 ? 0 : ans;
    }

     private Pair helper(TreeNode root) {

        if (root == null) {
            return new Pair(); 
        }

        Pair lp = helper(root.left);
        Pair rp = helper(root.right);

        Pair p = new Pair();

        if (lp.isBst && rp.isBst &&
            root.val > lp.leftMax &&
            root.val < rp.rightMin) {

            p.isBst = true;

            p.sum = lp.sum + rp.sum + root.val;

            p.leftMax = Math.max(root.val, rp.leftMax);
            p.rightMin = Math.min(root.val, lp.rightMin);

            ans = Math.max(ans, p.sum);

        } else {
            p.isBst = false;
        }

        return p;
    }
}