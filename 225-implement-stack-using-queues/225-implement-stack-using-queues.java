class MyStack {

    public MyStack() {
       
    }
    
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    
    public void push(int x) {
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        
        q1.add(x);
    }
    
    public int pop() {
        while(q1.size() != 1 ){
            int temp = q1.poll();
            q2.add(temp);
        }
        
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        return q1.poll();
    }
    
    public int top() {
        int temp = 0;
        while(q1.size() != 0 ){
            temp = q1.poll();
            q2.add(temp);
        }
        
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        return temp;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */