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
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode constructBST(int[] preO, int min, int max){
        if(idx == preO.length) return null;
        int data = preO[idx];
        if(data < min || data > max) return null;
        idx++;

        TreeNode root = new TreeNode(data);

        root.left = constructBST(preO ,min, root.val);
        root.right = constructBST(preO, root.val, max);

        return root;

    }
}