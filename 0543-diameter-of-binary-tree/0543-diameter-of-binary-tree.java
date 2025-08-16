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

    class Pair{
        int dia;
        int ht;
    }

    private Pair getDia(TreeNode root){
        if(root == null) return new Pair();

        Pair lp = getDia(root.left);
        Pair rp = getDia(root.right);

        Pair mp = new Pair();
        mp.ht = Math.max(lp.ht, rp.ht) + 1;

        int throughRoot = lp.ht + rp.ht; // path through current root
        mp.dia = Math.max(throughRoot, Math.max(lp.dia, rp.dia));

        return mp;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return getDia(root).dia;
    }
}