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

    public TreeNode buildTree(int[] p, int[] in) {
        Map<Integer, Integer> rootMap = new HashMap<>();
        for(int i = 0 ; i < in.length ; i++){
            rootMap.put(in[i], i);
        }
        return buildTree(p, in , 0, p.length -1 , 0, in.length -1, rootMap);
    }


    public TreeNode buildTree(int[] p, int[] in, int pSIdx, int pEIdx, int inSIdx, int inEIdx, Map<Integer, Integer> rootMap) {
        if(inSIdx > inEIdx || pSIdx > pEIdx ) return null;

        int data = p[pSIdx];
        int rootIdx = rootMap.get(data);

        int leftEle = rootIdx - inSIdx;
        int rightEle = inEIdx - rootIdx;

        TreeNode root = new TreeNode(data);

        root.left = buildTree(p, in, pSIdx + 1, pSIdx + leftEle, inSIdx, rootIdx - 1, rootMap);

        root.right = buildTree(p, in, pSIdx + leftEle + 1, pEIdx, rootIdx + 1, inEIdx, rootMap);

        return root;
    }
}