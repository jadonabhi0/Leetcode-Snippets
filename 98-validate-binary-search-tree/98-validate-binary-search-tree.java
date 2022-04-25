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
 public class BstPair{
        boolean isbst = true;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
}

class Solution {
//     public static long max(TreeNode root){
//         if(root == null) return Long.MIN_VALUE;
//         long m = max(root.right);
//         return Math.max(m,root.val);
//     }
    
//      public static long min(TreeNode root){
//         if(root == null) return Long.MAX_VALUE;
//         long m = min(root.left);
//         return Math.min(m,root.val);
//     }
    
   
    
    public boolean isValidBST(TreeNode root) {
        // if(root == null) return true;
        // boolean left = isValidBST(root.left);
        // boolean right = isValidBST(root.right);
        // long max = max(root.left);
        // long min = min(root.right);
        // if(left && right &&(max < root.val && min > root.val)) return true;
        // return false;
        
        return valid(root).isbst;
        
    }
    
    
     public BstPair valid(TreeNode node){
        if(node == null) return new BstPair();
        BstPair lbstp = valid(node.left);
        BstPair rbstp = valid(node.right);
        BstPair sbstp = new BstPair();
        sbstp.min = Math.min(lbstp.min,Math.min(rbstp.min , node.val));
        sbstp.max = Math.max(lbstp.max, Math.max(rbstp.max, node.val));
        if(lbstp.isbst && rbstp.isbst && (lbstp.max < node.val && rbstp.min > node.val)){
            sbstp.isbst = true;
            return sbstp;
        }
        sbstp.isbst = false;
        return sbstp;
    }
    
    
}