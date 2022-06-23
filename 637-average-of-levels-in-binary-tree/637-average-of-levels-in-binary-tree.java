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
    
    public void helper(TreeNode root, List<Double> list){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            
            long size = q.size();
            long div = size;
            long sum = 0;
            while(size-- > 0){
                
                TreeNode rmp = q.poll();
                
                sum += rmp.val;
                
                if(rmp.left != null){
                    q.offer(rmp.left);
                    
                }
                
                if(rmp.right != null){
                    q.offer(rmp.right);
                }
                
            }
            
            list.add((double)sum/div);
        }
        
    }
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
}