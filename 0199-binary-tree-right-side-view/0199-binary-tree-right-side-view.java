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
    public List<Integer> rightSideView(TreeNode root) {
        return levelOrder(root);        
    }

    public List<Integer> levelOrder(TreeNode root) {

            List<Integer> ans = new ArrayList<>();
            if (root == null) return ans;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                TreeNode last = null;

                for(int i = 0 ; i < size ; i++){
                    TreeNode rm = q.poll();
                    last = rm;
                    if(rm.left != null) q.offer(rm.left);
                    if(rm.right != null) q.offer(rm.right);
                }

                ans.add(last.val);

            }

        return ans;
    }


}