class Solution {
    public int lengthOfLIS(int[] nums) {
        // i --> Leading Pointer
        // j --> trailing Pointer
        
        if(nums.length ==0){
            return 0;
        }
       int dp[] = new int[nums.length];    
        dp[0] = 1;  //Bottom-up Approach
        int ans = 1;
        for(int i=1; i<dp.length; i++){ // Leading Pointer loop
            int max = 0;
            for(int j=0; j<i;j++){ // Trailing Pointer Loop
                if(nums[i] > nums[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}