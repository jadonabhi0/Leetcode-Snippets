class Solution {
    
    public int helper(int n, int[] cost, int[] dp){
        
        if(n <= 1) return dp[n] = cost[n];
        
        if(dp[n] != 0) return dp[n];
        
        return dp[n] = Math.min(helper(n - 1, cost, dp), helper(n - 2, cost, dp)) + cost[n];
    }
    
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2) return Math.min(cost[0],cost[1]);
        int[] dp = new int[cost.length];
        helper(cost.length - 1, cost, dp);
        return Math.min(dp[cost.length - 1] , dp[cost.length - 2]);
    }
}