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
        int ht;
        int dia;

        Pair(){}

        Pair(int ht, int dia){
            this.ht = ht;
            this.dia = dia;
        }

    }


    private Pair findDiameter(TreeNode root){
        if(root == null) {
            return new Pair(0, 0);
            
        }
        Pair lp = findDiameter(root.left);
        Pair rp = findDiameter(root.right);

        Pair p = new Pair();
        int maxHt = Math.max(lp.ht, rp.ht);
        p.ht = maxHt+1;

        int maxDia = Math.max(lp.ht+rp.ht, Math.max(lp.dia, rp.dia));
        p.dia = maxDia;


        return p;
    }

    public int diameterOfBinaryTree(TreeNode root) {

        return findDiameter(root).dia;

    }
}