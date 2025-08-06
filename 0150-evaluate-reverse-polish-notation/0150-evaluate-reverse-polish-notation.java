class Solution {
    public int evalRPN(String[] tokens) {
    Stack<Integer> st = new Stack<>();

    for (String ch : tokens) {
        if (ch.equals("+")) {
            st.push(st.pop() + st.pop());
        } else if (ch.equals("-")) {
            int b = st.pop();
            int a = st.pop();
            st.push(a - b);
        } else if (ch.equals("*")) {
            st.push(st.pop() * st.pop());
        } else if (ch.equals("/")) {
            int b = st.pop();
            int a = st.pop();
            st.push(a / b);
        } else {
            st.push(Integer.parseInt(ch));
        }
    }

    return st.peek();
}

}