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
    
    
    public List<List<Integer>> lot(TreeNode root, List<List<Integer>> ans,List<Integer> list){
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            TreeNode a = q.poll();
            
            if( a != null){
                
                list.add(a.val);
                
                if(a.left != null){
                     q.add(a.left);
                }
                
                if(a.right != null){
                    q.add(a.right);
                }
                
            }
            else{
                ans.add(0,list);
                list = new LinkedList<>();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            
            
        }
        
        return ans;
    }
    
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        if(root == null) return ans;
        return lot(root, ans, list);
        
    }
}