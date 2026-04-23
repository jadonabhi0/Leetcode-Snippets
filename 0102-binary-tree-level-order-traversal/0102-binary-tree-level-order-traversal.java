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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new LinkedList<>();
         if (root == null) return ans; 
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> label = new ArrayList<>();
            while(size-->0){
               TreeNode rm =  q.poll();
               label.add(rm.val); 
               if(rm.left != null) q.add(rm.left);
               if(rm.right != null) q.offer(rm.right);
            }
            ans.add(label);
        }

        return ans;
    }
}