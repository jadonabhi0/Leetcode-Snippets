/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = addInMap(node, new HashMap<>());
        
        for(Node key : map.keySet()){
            for(Node nbr : key.neighbors){
                 map.get(key).neighbors.add(map.get(nbr));
            }
        }
        return map.get(node);
    }

    private HashMap<Node, Node> addInMap(Node node,  HashMap<Node, Node> map){
        if (node == null) return map;

        if(map.containsKey(node)) return map;

        // put all old nodes (key) in map with newNode(value)
        map.put(node, new Node(node.val));

        for(Node nbr : node.neighbors){
            addInMap(nbr, map);
        } 

        return map;
    }
}