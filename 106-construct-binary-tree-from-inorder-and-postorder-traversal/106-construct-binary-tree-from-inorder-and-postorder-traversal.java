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
    
    private TreeNode Bst_From_In_And_Post(int[] postorder, int poststart, int postend, int[] inorder, int instart, int inend){

        if (instart > inend) return null;

        int idx = instart;
        TreeNode node  = new TreeNode(postorder[postend]);
        while(postorder[postend] != inorder[idx] && idx < inend) ++idx;
        int count = idx - instart;

//        System.out.println("jjhjkh");
        node.left = Bst_From_In_And_Post(postorder, poststart,poststart+count-1, inorder, instart, idx-1);
        node.right = Bst_From_In_And_Post(postorder, poststart+count,postend-1, inorder, idx+1, inend);
        return node;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int n = inorder.length;
        
        return  Bst_From_In_And_Post(postorder,0, n-1, inorder, 0, n-1);
        
    }
}