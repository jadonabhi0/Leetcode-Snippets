class Solution {
    public int calPoints(String[] ops) {
        
        Stack<Integer> st = new Stack<>();
        int sum = 0;
        
        for(String s : ops){
            
            if(s.equals("C")){
                st.pop();
            }else if(s.equals("D")){
                st.push(st.peek()*2);
            }else if(s.equals("+")){
                int a1 = st.pop();
                int a2 = a1 + st.peek();
                st.push(a1);
                st.push(a2);
            
            }else{
                int x = Integer.valueOf(s);
                st.push(x);
                
            }
            
        }
        
        for(int val : st){
            sum += val;
        }
        
        return sum;
    }
}