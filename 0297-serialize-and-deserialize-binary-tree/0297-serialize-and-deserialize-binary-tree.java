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
        StringBuilder sb = new StringBuilder();
        serializerHelper(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deSerializerHelper(q);
    }


    private StringBuilder serializerHelper(TreeNode node , StringBuilder sb){
        if(node == null){
            sb.append("#,");
            return sb;
        }
        sb.append(node.val).append(",");
        serializerHelper(node.left, sb);
        serializerHelper(node.right, sb);
        return sb;
    }

    private TreeNode deSerializerHelper(Queue<String> q){
        String rm = q.poll();
        if("#".equals(rm)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(rm));
        root.left = deSerializerHelper(q);
        root.right = deSerializerHelper(q);
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));