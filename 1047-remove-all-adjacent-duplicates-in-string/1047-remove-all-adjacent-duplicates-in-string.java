class Solution {
    public String removeDuplicates(String str) {
        Stack<String> st = new Stack<>();
        
        for(int i = 0 ; i < str.length() ; i++){
            
            String s = str.charAt(i)+"";
            
            if(st.isEmpty()){
                st.push(s);
            }else if(s.equals(st.peek())){
                st.pop();
            }else{
                st.push(s);
            }
            
        }
        
        String ans = "";
        
        for(String val : st){
            ans += val;
        }
        
        return ans;
    }
}