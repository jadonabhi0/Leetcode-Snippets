class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
        
        for(String s : tokens){
            
            if(s.equals("+")){
                int a1 = st.pop();
                int a2 = st.pop();
                st.push(a1+a2);
                
            }else if(s.equals("-")){
                int a3 = st.pop();
                int a4 = st.pop();
                st.push(a4-a3);
                
                
            }else if(s.equals("*")){
                int a5 = st.pop();
                int a6 = st.pop();
                st.push(a5*a6);
                
                
            }else if(s.equals("/")){
                int a7 = st.pop();
                int a8 = st.pop();
                st.push(a8/a7);
                
                
            }else{
                int num = Integer.valueOf(s);
                st.push(num);
            }
            
        }
        return st.peek();
    }
}