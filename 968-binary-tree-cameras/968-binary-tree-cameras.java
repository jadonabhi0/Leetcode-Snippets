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
    
    public static int camera = 0;
    
    // -1 --> camera need hai;
    //  1 --> already covered hai;
    //  0 --> node ke pass camera hai
    
    public int helper(TreeNode root){
        
        if(root == null) return 1;
        
        int lchild = helper(root.left);
        int rchild = helper(root.right);
        
        if(lchild == -1 || rchild == -1){ // camera nhi hai, need hai
            camera++;
            return 0;
        }
        
        if(lchild == 0 || rchild == 0){ // camera hai
            return 1;
        }
        
        return -1; // cover hai already
        
    }
    
    public int minCameraCover(TreeNode root) {
        camera = 0;
        if(helper(root) == -1) camera++;
        return camera;
    }
}