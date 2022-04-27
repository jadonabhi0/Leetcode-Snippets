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
    static int idx = 0;
    public TreeNode bstFromPreorder(int[] pre) {
        if(pre.length == 0) return null;
        idx = 0;
        return bstHelper(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    static TreeNode bstHelper(int[] pre, int start ,int end){
        if(idx == pre.length || pre[idx] < start || pre[idx] > end) return null;
        int val = pre[idx++];
        TreeNode node = new TreeNode(val);
        node.left = bstHelper(pre,start,val);
        node.right = bstHelper(pre,val,end);
        return node;
    }
    
}