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
    
    public static TreeNode create_Tree(int[] array, int lo, int hi){
        if(lo > hi) return null;
        int mid = (lo+hi)/2;
        TreeNode node = new TreeNode(array[mid]);
        node.left = create_Tree(array, lo, mid-1);
        node.right = create_Tree(array, mid+1, hi);
        return node;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return create_Tree(nums, 0, nums.length-1);
    }
}