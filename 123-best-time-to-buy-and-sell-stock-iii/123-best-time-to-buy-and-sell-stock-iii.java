class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        int ovmax = 0;
        int profit = 0;
        int min = Integer.MAX_VALUE;
        
        
        for(int i = 0 ; i < n ; i++){
            min = Math.min(min, prices[i]);
            profit = prices[i] - min;
            ovmax = Math.max(ovmax, profit);
            dp1[i] = ovmax;
        }
        
        int max = Integer.MIN_VALUE;
        profit = 0;
        ovmax = 0;
        
        for(int i = n - 1 ; i >= 0 ; i--){
            max = Math.max(max, prices[i]);
            profit = max - prices[i];
            ovmax = Math.max(profit, ovmax);
            dp2[i] = ovmax;
        }
        
        ovmax = 0;
        
        for(int i = 0 ; i < n ; i++){
            ovmax = Math.max(ovmax, dp1[i]+dp2[i]);
        }
        
        return ovmax;
    }
}