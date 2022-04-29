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
    static List<String> list = new LinkedList<>();
    
    public void path(TreeNode root, String path){
        if(root == null) return ;
        
        if(root.left == null && root.right == null){
            list.add(path+root.val);
        }
        
        path(root.left, path+root.val+"->");
        path(root.right, path+root.val+"->");
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        list = new LinkedList<>();
        if(root == null) return list;
        
        path(root,"");
        
        return list;
    }
}