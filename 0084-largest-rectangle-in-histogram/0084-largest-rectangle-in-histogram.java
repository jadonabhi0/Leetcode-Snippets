class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] ls = new int[n];
        int[] rs = new int[n];

        // find the right smaller
        rs[n-1] = n;
        st.push(n-1);

        for(int i = n-2 ; i >= 0 ; i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) st.pop();
            rs[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        } 

        st.clear();

        // find left smaller

        ls[0] = -1;
        st.push(0);

        for(int i = 1 ; i < n ; i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) st.pop();
            ls[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        } 
        // cal area

        int maxA = 0;

        for(int i = 0 ; i < n ; i++){
            int wid = rs[i] - ls[i] - 1;
            int area = wid * heights[i];
            maxA = Math.max(maxA, area);

        }

        return maxA;
    }
}