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
    
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list  = new ArrayList<>();
    
    public void helper(TreeNode root, int tar)   {
        
        if(root == null) return ;
        if(root.left == null  && root.right == null && tar == root.val){
            list.add(root.val);
            ans.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        
        list.add(root.val);
        helper(root.left,tar-root.val);
        helper(root.right,tar-root.val);
        list.remove(list.size()-1);
    }
    
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        helper(root,targetSum);
        return ans;
    }
}