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
    
    public boolean isPresent(TreeNode root, int sum , Set<Integer> set){
        if(root == null) return false;
        if(isPresent(root.left,sum,set) == true) return true;
        if(set.contains(sum-root.val)) return true;
        set.add(root.val);
        return isPresent(root.right,sum,set);
    }
    
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        boolean res = isPresent(root,k,set);
        return res;
    }
}