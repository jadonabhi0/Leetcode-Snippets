class Solution {
public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);

            //check if current char is open parentheses
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                //push it into stack
                st.push(currentChar);
            } else {
                if (st.isEmpty()) return false;

                if (st.peek() == '(' && currentChar == ')') st.pop();

                else if (st.peek() == '[' && currentChar == ']') st.pop();

                else if (st.peek() == '{' && currentChar == '}') st.pop();

                else return false;
            }
        }
        //if stack is empty return true
        return st.isEmpty();
    }
}