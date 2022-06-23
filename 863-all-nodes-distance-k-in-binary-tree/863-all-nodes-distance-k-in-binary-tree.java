/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private void kthLevel_(TreeNode root, int level, List<Integer> list, TreeNode blocker){
        if (root == null || level < 0 || root == blocker) return;
        if (level == 0) list.add(root.val);
        kthLevel_(root.left, level-1, list,blocker);
        kthLevel_(root.right, level-1, list,blocker);
    }

    public List<Integer> kthLevel(TreeNode root, int k,TreeNode blocker){
        List<Integer> list = new ArrayList<>();
        kthLevel_(root,k,list,blocker);
        return list;
    }
    
    private boolean rootToLeaf_(TreeNode root, TreeNode target,List<TreeNode> list){
        if (root == null) return false;
        if (root == target) {
            list.add(root);
            return true;
        }
        boolean res = rootToLeaf_(root.left,target,list) || rootToLeaf_(root.right, target, list);
        if(res)list.add(root);
        return res;
    }

    public List<TreeNode> rootToLeaf(TreeNode root, TreeNode tar){
        List<TreeNode> list = new ArrayList<>();
        rootToLeaf_(root,tar,list);
        return list;
    }
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> ans = new ArrayList<>();
        List<TreeNode> list = rootToLeaf(root,target);
        
        for(int i = 0 ; i < list.size() ; i++){
            List<Integer> bb = kthLevel(list.get(i),k-i, i == 0 ? null : list.get(i-1));
            ans.addAll(bb);
        }
        return ans;
        
    }
}