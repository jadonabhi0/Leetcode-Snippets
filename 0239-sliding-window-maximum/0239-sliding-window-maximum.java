class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] nge = nge(nums);

        int j = 0;

        for (int i = 0; i <= n - k; i++) {

            if (j < i)
                j = i;

            while (nge[j] < i + k) {
                j = nge[j];
            }

            ans[i] = nums[j];
        }

        return ans;
    }

    private int[] nge(int[] nums) {

        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        nge[n - 1] = n; // No greater element to the right

        for (int i = n - 2; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        return nge;
    }
}