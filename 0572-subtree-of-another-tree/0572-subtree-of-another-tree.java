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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null) return false;
        
        if(root.val == subRoot.val){
            if(isSameTree(root, subRoot)){
                return true;
            }
        }

        boolean l = isSubtree(root.left, subRoot);
        boolean r = isSubtree(root.right, subRoot);

        // if(l || r) return true;

        return l || r;
        
    }


    private boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;

        if(p == null || q == null) return false;
        
        if(p.val != q.val) return false;


        boolean l = isSameTree(p.left, q.left);
        boolean r = isSameTree(p.right, q.right);

        if(!l || !r) return false;

        return l && r;
        
    }

}