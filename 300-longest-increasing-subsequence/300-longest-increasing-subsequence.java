class Solution {
    
    public static int helper_memo(int[] array, int prev, int curr, int[][] dp){
        if (curr == array.length) return 0;
        if (prev != -1 && dp[prev][curr] != 0) return dp[prev][curr];
        int a = 0;
        if(prev == -1 || array[prev] < array[curr]){
            a = helper_memo(array, curr, curr+1, dp) + 1;
        }
        int b = helper_memo(array,prev,  curr+1, dp);

        if (prev != -1){
            dp[prev][curr] = Math.max(a, b);
        }
        return  Math.max(a, b);
    }
    
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return helper_memo(nums, -1, 00, dp);
    }
}