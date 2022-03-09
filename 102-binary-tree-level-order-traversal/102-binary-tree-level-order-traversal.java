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
    
    
    public static List<Integer> level(TreeNode root, int le, LinkedList<Integer> list){
        if(root == null) return list ;
        if(le == 1) list.add(root.val);
        else if(le>1){
            level(root.left,le-1,list);
            level(root.right,le-1,list);
        }
        return list;
    }
    
    public static int height(TreeNode root){
        if (root == null) return 0;
        int a = height(root.left);
        int b = height(root.right);
        int c = Math.max(a,b)+1;
        return c;
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        int n = height(root);
        for(int i = 1 ;i <= n ; i++){
            LinkedList<Integer> list = new LinkedList<>();
            List<Integer> store = level(root,i,list);
            res.add(store);
        }
        return res;
    }
}