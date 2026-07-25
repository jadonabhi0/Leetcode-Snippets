class Solution {
    public int largestRectangleArea(int[] ht) {
        int n = ht.length;
        int[] ls = getNextSmaller(ht, 'l');
        int[] rs = getNextSmaller(ht, 'r');
        System.out.println(Arrays.toString(ls));
        System.out.println(Arrays.toString(rs));
        int maxArea = 0;

        for(int i = 0 ; i < n ; i++){
            int width = rs[i] - ls[i]-1;
            int area = width*ht[i];

            if(area > maxArea){
                maxArea = area;
            }
        }

        return maxArea;
        
    }

    private int[] getNextSmaller(int[] arr, char dir){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        if(dir == 'l'){
            st.push(0);
            ans[0] = -1;
            for(int i = 1 ; i < arr.length ; i++){
                while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
                ans[i] = st.isEmpty() ? -1 : st.peek();
                st.push(i);
            }
        }
        
        if(dir == 'r'){
            st.push(arr.length-1);
            ans[arr.length-1] = arr.length;


            for(int i = arr.length-2 ; i >= 0 ; i--){
                while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
                ans[i] = st.isEmpty() ? arr.length : st.peek();
                st.push(i);
            }

        }

        return ans;
    }

}