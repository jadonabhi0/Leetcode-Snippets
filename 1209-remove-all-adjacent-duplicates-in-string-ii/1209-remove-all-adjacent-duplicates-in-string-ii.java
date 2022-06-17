class Solution {
    public String removeDuplicates(String s, int k) {
        
        
        // creating the stack of int[] array to keep track the records;
        Stack<int[]> st = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            
            char ch = s.charAt(i);
            
            
            if(!st.isEmpty() && ch == st.peek()[0]){
                st.peek()[1]++;
            }
            else{
                st.push(new int[]{ch,1});
            }
            
            if(st.peek()[1] == k){
                st.pop();
            }
            
        }
        
        
        StringBuffer sb = new StringBuffer();
        
        for(int[] array : st){
            
            while(array[1]--> 0){
                char c = (char)array[0];
                sb.append(c);
            }
        }
        
        return sb.toString();
        
    }
}