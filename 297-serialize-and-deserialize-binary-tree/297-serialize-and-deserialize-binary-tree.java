/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "x";
        }
        
        String leftSer = serialize(root.left);
        String rightSer = serialize(root.right);
        return root.val+","+leftSer+","+rightSer;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodeleft = new LinkedList<>();
        nodeleft.addAll(Arrays.asList(data.split(",")));
        return deserializehelp(nodeleft);
    }
    
    public TreeNode deserializehelp(Queue<String> nodeleft){
        String valueOfNode = nodeleft.poll();
        if(valueOfNode.equals("x")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(valueOfNode));
        node.left =  deserializehelp(nodeleft);
        node.right =  deserializehelp(nodeleft);
        return node;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));