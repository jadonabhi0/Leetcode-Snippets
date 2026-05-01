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
        if(node == null) return null;
        HashMap<Node,Node> map = graphToMap(node,new HashMap<>());
        for(Node n : map.keySet()){
            for(Node nbr : n.neighbors){
                map.get(n).neighbors.add(map.get(nbr));
            }
        }
        return map.get(node);
    }

    private HashMap<Node,Node> graphToMap(Node node, HashMap<Node, Node> map){
        if(map.containsKey(node)) return map;
        map.put(node, new Node(node.val));
        for(Node nbr : node.neighbors){
            if(!map.containsKey(nbr)){
                graphToMap(nbr,map);
            }
        }
        return map;
    }

}