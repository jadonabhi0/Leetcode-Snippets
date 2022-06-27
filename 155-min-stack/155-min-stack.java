class MinStack {
    private Stack<Integer> vals = new Stack<>();
    private Stack<Integer> mins = new Stack<>();

    public void push(int x) {
        vals.push(x);
		
        if(!mins.isEmpty())
            mins.push(Math.min(mins.peek(), x));
        else
            mins.push(x);
    }

    public void pop() {
        vals.pop();
        mins.pop();
    }

    public int top() {
        return vals.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */