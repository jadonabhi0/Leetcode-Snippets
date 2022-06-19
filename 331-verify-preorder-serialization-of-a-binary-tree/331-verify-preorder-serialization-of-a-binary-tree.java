class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> st = new Stack<>();
        String[] array = preorder.split(",");
        
        for(String val : array){
            
            if(val.equals("#")){
                while(st.size() >= 2 && st.peek().equals("#")){
                    st.pop();
                    if(!st.peek().equals("#")){
                        st.pop();
                    }
                }
                
            }
            st.push(val);
            
        }
        
        return st.size() == 1 && st.pop().equals("#");
    }
}