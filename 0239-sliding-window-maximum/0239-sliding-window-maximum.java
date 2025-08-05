class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(k == 1) return nums;

        Stack<Integer> st = new Stack<Integer>();
        int n = nums.length;
        int[] nge = new int[n];
        int[] ans = new int[n-k+1];

        // Build the Next Greater Element index array
        nge[n - 1] = n; // Important fix
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek(); // -1 if no greater element
            st.push(i);
        }


        // making ans
        int j = 0;
        for(int i = 0 ; i <= n - k ; i++){
            if(j < i){
                j = i;
            }

            while(nge[j] < i+k){
                    j = nge[j];
            }
            ans[i] = nums[j];
            
        }
        return ans;

    }
}