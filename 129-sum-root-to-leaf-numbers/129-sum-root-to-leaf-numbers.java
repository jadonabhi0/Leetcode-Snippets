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
    
    public static List<Integer> leafToPath(TreeNode root, String path, List<Integer> list){
        if(root == null) return list;
        
        if(root.left == null && root.right == null){
            int a = Integer.parseInt(path+root.val);
            list.add(a);
        }
        
        leafToPath(root.left,path+root.val,list);
        leafToPath(root.right,path+root.val,list);
        return list;
        
    }
    
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        List<Integer> list = new LinkedList<>();
        if(root == null) return sum;
        list = leafToPath(root,"",list);
        for(int i : list){
            sum += i;
        }
        return sum;
    }
}