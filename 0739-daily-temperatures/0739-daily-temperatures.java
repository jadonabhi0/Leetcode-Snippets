class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        ans[n-1] = 0;
        st.push(n-1);

        for(int i = n - 2 ; i >= 0 ; i--){
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = 0;
            }else{
                ans[i] = st.peek() - i;
            }

            st.push(i);
        }    
        return ans;
    }
}