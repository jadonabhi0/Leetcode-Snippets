class MinStack {

    private ArrayList<Integer> st;
    private ArrayList<Integer> minSt;



    public MinStack() {
        st = new ArrayList();
        minSt = new ArrayList();
    }
    
    public void push(int val) {
        st.add(val);

        if(minSt.isEmpty()){
            minSt.add(val);
        }else{
            int min = Math.min(val, minSt.get(minSt.size()-1));
            minSt.add(min);
        }
    }
    
    public void pop() {
        int popped = st.remove(st.size() - 1);
        minSt.remove(minSt.size() - 1);

    }
    
    public int top() {
        return st.get(st.size()-1);
    }
    
    public int getMin() {
        return minSt.get(minSt.size() - 1);
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