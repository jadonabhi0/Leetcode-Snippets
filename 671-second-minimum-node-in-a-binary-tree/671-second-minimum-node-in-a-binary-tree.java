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
    public void inorder(TreeNode root,TreeSet<Integer> set){
        if(root == null) return;
        inorder(root.left, set);
        set.add(root.val);
        inorder(root.right, set);
    }
    
    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        inorder(root, set);
        if(set.size() == 1) return -1;
        set.pollFirst();
        return set.pollFirst();
    }
}