class Solution {
    
     public static int helper_tabu(int n, int[] cost, int[] dp){
        if(cost.length == 2) return Math.min(cost[0],cost[1]);

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2 ; i < n ; i++){
            dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
    
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        return helper_tabu(cost.length , cost, dp);
        
    }
}