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
    
        public void helper(TreeNode root, List<Integer> list){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            
            long size = q.size();
            int ans = Integer.MIN_VALUE;
            while(size-- > 0){
                
                TreeNode rmp = q.poll();
                
                ans = Math.max(rmp.val,ans);
                
                if(rmp.left != null){
                    q.offer(rmp.left);
                    
                }
                
                if(rmp.right != null){
                    q.offer(rmp.right);
                }
                
            }
            
            list.add(ans);
        }
        
    }
    
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
}