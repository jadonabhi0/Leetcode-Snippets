class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else if (ch == ')') {
                reverseStr(arr, st.pop() + 1, i - 1);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : arr) {
            if (c != '(' && c != ')') ans.append(c);
        }
        return ans.toString();
    }

    private void reverseStr(char[] arr, int lo, int hi) {
        while (lo < hi) {
            char temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            lo++;
            hi--;
        }
    }
}