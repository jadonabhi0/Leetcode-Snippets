class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);

        return Math.min(
                helper(0, cost, dp),
                helper(1, cost, dp)
        );
    }

    private int helper(int i, int[] cost, int[] dp) {

        if (i >= cost.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        return dp[i] = cost[i] +
                Math.min(
                        helper(i + 1, cost, dp),
                        helper(i + 2, cost, dp)
                );
    }
}