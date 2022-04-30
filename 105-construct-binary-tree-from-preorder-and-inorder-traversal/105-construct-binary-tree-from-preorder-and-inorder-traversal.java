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
    
    
    int idx = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode arrToBst(int[] array, int start, int end){
        if(start > end)
        {
            return null;
        }
        
        int rval = array[idx++];
        TreeNode node = new TreeNode(rval);
        node.left = arrToBst(array,start,map.get(rval) - 1);
        node.right = arrToBst(array,map.get(rval)+1, end);
        return node;
        
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i], i);
        }
        
        return arrToBst(preorder, 0, preorder.length-1);
    }
}