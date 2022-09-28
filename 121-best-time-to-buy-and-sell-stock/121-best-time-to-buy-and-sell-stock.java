class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        int ovmax = Integer.MIN_VALUE;
        int buyingCost = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < prices.length ; i++){
            buyingCost = Math.min(buyingCost, prices[i]);
            profit = prices[i] - buyingCost;
            ovmax = Math.max(ovmax, profit);
        }
        
        return ovmax;
        
    }
}