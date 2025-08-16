class LRUCache {


    class ListNode{
        Integer key, val;
        ListNode next, prev;

        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        public ListNode(){
            this.key = null;
            this.val = null;
            this.next = null;
            this.prev = null;
        }

    }


    private ListNode head;
    private ListNode tail;
    private HashMap<Integer, ListNode> map ;


    int cap = 0;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity;
        head = new ListNode();
        tail = new ListNode();

        head.next = tail;
        head.prev = null;

        tail.next = null;
        tail.prev = head;
    }

    private ListNode addFirst(ListNode node){
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;

        return node;
    }


    private void deleteNode(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private ListNode removeLRU(){
        ListNode delNode = tail.prev;
        delNode.prev.next = tail;
        tail.prev = delNode.prev;
        return delNode;
    }

    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        ListNode node = map.get(key);
        deleteNode(node);
        addFirst(node);
        return node.val;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            deleteNode(map.get(key)); 
            map.put(key, addFirst(new ListNode(key, value)));
            return;

        }

        if(map.size() == cap){
            ListNode lru = removeLRU();
            map.remove(lru.key);
        }
        
        map.put(key, addFirst(new ListNode(key, value)));

    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */