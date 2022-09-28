class Solution {
    public int maxProfit(int[] prices) {
        int ovmax = 0;
        for(int i = 1 ; i < prices.length ; i++){
            if(prices[i] > prices[i-1]){
                ovmax += prices[i] - prices[i-1];
            }
        }
        return ovmax;
    }
}