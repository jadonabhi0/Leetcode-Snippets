class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0) return 0;
        int [][] dp = new int[k+1][prices.length];

        for(int kthDay = 1 ; kthDay <= k ; kthDay++){
            for (int day = 1 ; day < prices.length ; day++){
                int max = Integer.MIN_VALUE;
                for(int i = 0 ; i < day ; i++){
                    max = Math.max(max, dp[kthDay-1][i] + prices[day] - prices[i]);
                }
                dp[kthDay][day] = Math.max(max, dp[kthDay][day-1]);
            }
        }
        return dp[k][prices.length-1];
    }
}