class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int dest = nums.length-1;
        dp[dest] = 0;
        for(int i = nums.length-2 ; i >= 0 ; i--){
            int min = Integer.MAX_VALUE;
            for(int j = i+1 ; j <= Math.min(i+nums[i],dest) ; j++){
                min = Math.min(min,dp[j]);
            }
            if(min != Integer.MAX_VALUE){
                dp[i] = min+1;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}