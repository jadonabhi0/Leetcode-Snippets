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
    
    public List<List<Integer>> levelOrder(List<List<Integer>> list , TreeNode root, int level){
        if(root == null) return list;
        if(list.size() <= level){
           List<Integer> l = new LinkedList<>();
           list.add(l); 
        }
        if(level % 2 == 0){
            list.get(level).add(root.val);
        }else{
            list.get(level).add(0,root.val);
        }
        levelOrder(list,root.left,level+1);
        levelOrder(list,root.right,level+1);
        return list;
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l = new LinkedList<>();
        List<List<Integer>> ans = levelOrder(l,root,0);
        return ans;
        
    }
}