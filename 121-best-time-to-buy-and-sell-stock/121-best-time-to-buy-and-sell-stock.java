class Solution {
    public int maxProfit(int[] prices) {
        int minbuycost = Integer.MAX_VALUE;
        int profit = 0;
        int overalmaxprofit = 0;
        
        for(int i = 0 ; i < prices.length ; i++){
            minbuycost = Math.min(minbuycost, prices[i]);
            profit = prices[i] - minbuycost ;
            overalmaxprofit = Math.max(overalmaxprofit, profit);
        }
        return overalmaxprofit;
    }
}