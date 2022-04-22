class Solution {
    public int maxProfit(int[] prices) {
        
        int leastsofar = Integer.MAX_VALUE;
        int overalprofit = 0;
        int profitiftoday = 0;
        
        for(int i = 0 ; i < prices.length ; i ++){
            if(prices[i] < leastsofar){
                leastsofar = prices[i];
;            }
            
            profitiftoday = prices[i] - leastsofar;
            if(profitiftoday > overalprofit){
                overalprofit = profitiftoday;
            }
        }
        return overalprofit;
    }
}