class Solution {
    public int maxProfit(int[] prices) {
        
        int buyDay = prices[0];

        int ans = 0;

        for(int i : prices){

            buyDay = Math.min(buyDay, i);

            int profit = i - buyDay;

            ans = Math.max(ans, profit);


        }

        return ans;

    }
}