/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        HashMap<Node, Node> map = new HashMap<>();
        for(Node temp = head ;temp != null ; temp = temp.next) map.put(temp,new Node(temp.val));
        for(Node temp = head ;temp != null ; temp = temp.next){
            map.get(temp).next = map.getOrDefault(temp.next, null);
            map.get(temp).random = map.getOrDefault(temp.random, null);
        }
        return map.get(head);
    }
}