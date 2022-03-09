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
    public boolean valid(TreeNode root,long min ,long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return (valid(root.left,min,root.val) && valid(root.right,root.val,max));
    }
    public boolean isValidBST(TreeNode root) {
       return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
//         TreeNode prev = null;
//         if(root != null){
//             if(!isValidBST(root.left)){
//                 return false;
//             }
//             if(prev != null && root.val <= prev.val){
//                 return false;
//             }
//               if(prev != null || prev.val == root.val) return false;
            
//             prev = root;
//             return isValidBST(root.right);
//         }
        
//         return true;
    }
}