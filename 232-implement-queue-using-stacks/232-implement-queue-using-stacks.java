class MyQueue {

    public MyQueue() {
        
    }
    
    Stack<Integer> st1 =new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    public void push(int x) {
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        st1.push(x);
    }
    
    public int pop() {
         while(!st2.isEmpty()){
            st1.push(st2.pop());
         }
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        return st2.pop();
    }
    
    public int peek() {
         while(!st2.isEmpty()){
            st1.push(st2.pop());
         }
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        return st2.peek();
    }
    
    public boolean empty() {
        return (st1.isEmpty() && st2.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */