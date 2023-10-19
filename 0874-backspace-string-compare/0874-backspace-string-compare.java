class Solution {
     String cutter(String str){
        Stack<Character> st = new Stack<>();
        char[] array = str.toCharArray();
        for(char c : array){
            if(c != '#'){
                st.push(c);
            }else if(!st.empty()){
                st.pop();
            }
        }
        return String.valueOf(st);
       
    }
    public boolean backspaceCompare(String s, String t) {
        return cutter(s).equals(cutter(t));
    }
}