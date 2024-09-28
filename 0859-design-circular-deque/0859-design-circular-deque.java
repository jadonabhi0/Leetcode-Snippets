class MyCircularDeque {

    int size = 0;
    
    class Node {
        int val;
        Node next;
        Node prev;
        public Node(int v) { val = v; }
    }
    
    Node head;
    Node tail;
    int capacity;
    
    public MyCircularDeque(int k) {
        size = k;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        
        Node n = new Node(value);
        
        if(isEmpty()) {
            head = tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        
        capacity++;
        
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) return false;
        
        Node n = new Node(value);
        
        if(isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        
        capacity++;
        
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        
        head = head.next;
        capacity--;
        
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        
        tail = tail.prev;
        capacity--;

        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : head.val;
    }
    
    public int getRear() {
        return isEmpty() ? -1 : tail.val;
    }
    
    public boolean isEmpty() {
        return capacity == 0;
    }
    
    public boolean isFull() {
        return capacity == size;
    }
}