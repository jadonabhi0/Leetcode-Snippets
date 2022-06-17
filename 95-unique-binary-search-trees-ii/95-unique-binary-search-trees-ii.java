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
    
    public List<TreeNode> helper(int low, int high){
        
        if(low > high){
            List<TreeNode> base = new ArrayList<>();
            base.add(null);
            return base;
        }
        
        List<TreeNode> ans = new ArrayList<>();
        for(int i = low ; i <= high ; i++){
            
            List<TreeNode> left = helper(low, i-1);
            List<TreeNode> right = helper(i+1, high);
            
            for(TreeNode l : left){
                
                for(TreeNode r : right){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    ans.add(node);
                }
            }
            
        }
        return ans;
    }
    
    public List<TreeNode> generateTrees(int n) {
        
        return helper(1,n);
        
    }
    
    
    
}