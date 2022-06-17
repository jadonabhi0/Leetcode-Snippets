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
    
    public static int total = 0;
    
    public void helper(TreeNode root, int sum, int target, Map<Integer,Integer> map){
        
        if(root == null) return;
        
        sum += root.val;
        int temp = sum - target;
        
        if(map.containsKey(temp)){
            total += map.get(temp);
        }
        
        map.put(sum, map.getOrDefault(sum,0)+1);
        helper(root.left, sum, target, map);
        helper(root.right, sum, target, map);
        map.put(sum, map.get(sum)-1);
        
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        total = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root,0, targetSum, map);
        return total;
    }
}