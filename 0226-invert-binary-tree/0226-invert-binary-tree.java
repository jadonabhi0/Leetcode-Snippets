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

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root){
        if(root == null) return;
        invert(root.left);
        invert(root.right);
        

        if(root.left != null && root.right != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }else if(root.left == null && root.right != null){
            root.left = root.right;
            root.right = null;
        }else{
            root.right = root.left;
            root.left = null;
        }

    }
 
}