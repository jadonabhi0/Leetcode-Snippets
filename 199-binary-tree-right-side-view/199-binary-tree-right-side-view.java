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
    static List<Integer> list = new  LinkedList<>();
    private static void rightView(TreeNode root, int level){
        if (root == null) return;
        if (list.size() == level){
            list.add(root.val);
        }
        rightView(root.right, level+1);
        rightView(root.left, level+1);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        list = new  LinkedList<>();
        if(root == null) return list;
        rightView(root,0);
        return list;
    }
}