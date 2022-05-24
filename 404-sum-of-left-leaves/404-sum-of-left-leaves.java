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
    
    int ans = 0;
        // FIRST APPROCH
    
//     public ArrayList<Integer> help(TreeNode root, int sum, ArrayList<Integer> list){
//         if(root == null) return list;
        
//        if(root.left != null && root != null){
//             if(root.left.left == null && root.left.right == null){
//                 list.add(root.left.val);
//             }
//        }
        
//        if(root.right != null){
//             help(root.right,sum,list);
//        }
//        if(root.left != null){
//            help(root.left,sum,list);
//        }
//         return list;
//     }
    
    
    public int help(TreeNode node, boolean flag){
        if(node == null) return 0;
        
        if(node.left == null && node.right == null && flag == true){
            ans += node.val;
        }
        help(node.left, true);
        help(node.right, false);
        return ans;
    }
    
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left == null  && root.right == null)
        {
            return 0;
        }
        
        if(root == null){
            return 0;
        }
//         ArrayList<Integer> list = new ArrayList<>();
//         help(root, 0, list);
//         int count = 0;
//         for(int i : list){
//             count += i;
//         }
//         return count;
        
        
        //-------
        
        return help(root,false);
    }
}