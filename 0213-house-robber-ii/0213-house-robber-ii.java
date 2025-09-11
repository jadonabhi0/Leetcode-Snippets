class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int a = rob(nums, 1, n-1);
        int b = rob(nums, 0, n-2);
        return Math.max(a, b);
    }

    private int rob(int[] nums, int i, int j){
        int n = j-i+1;
        if(n == 1) return nums[i];

        int[] dp = new int[j+1];

        dp[i] = nums[i];
        dp[i+1] = Math.max(nums[i], nums[i+1]);

        for(int idx = i+2 ; idx <= j ; idx++){
            dp[idx] = Math.max(dp[idx-1], nums[idx] + dp[idx-2]);
        }

        return dp[j];

    }

}