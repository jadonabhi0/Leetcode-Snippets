class MyCircularQueue {
    
    int[] array;
    int front;
    int rare;
    int size ;
    public MyCircularQueue(int k) {
        array = new int[k];
        front = -1;
        rare = -1;
        size = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(front == -1){
            front = 0;
        }
        
        rare = (rare+1) % size;
        array[rare] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        array[front] = 0;
        if(front == rare){
            front = rare = -1;
        }else{
            front = (front + 1) % size;
        }
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return array[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return array[rare];
    }
    
    public boolean isEmpty() {
        return rare == -1 && front == -1;
    }
    
    public boolean isFull() {
        return (rare + 1) % size == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */