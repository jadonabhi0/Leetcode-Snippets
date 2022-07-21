class Solution {
    public int maxProfit(int[] prices) {
        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];

//      [3,3,5,0,0,3,1,4]

        int pastMin = Integer.MAX_VALUE;
        int profit = 0;
        int maxProfit = 0;


        for(int i = 0 ; i < prices.length ; i++){
            pastMin = Math.min(pastMin, prices[i]);
            profit = prices[i] - pastMin;
            maxProfit = Math.max(profit, maxProfit);
            dp1[i] = maxProfit;
        }

        profit = 0;
        maxProfit = 0;
//       [3,3,5,0,0,3,1,4]
        int futureMax = Integer.MIN_VALUE;
        for(int i = prices.length-1 ; i >= 0 ; i--){
            futureMax = Math.max(futureMax, prices[i]);
            profit = futureMax - prices[i];
            maxProfit = Math.max(profit,maxProfit);
            dp2[i] = maxProfit;
        }

        // System.out.println(Arrays.toString(dp1));
        // System.out.println(Arrays.toString(dp2));

        int overAllProfit = 0;

        for(int i = 0 ; i < dp1.length ; i++){
            overAllProfit = Math.max(overAllProfit, dp1[i]+dp2[i]);
        }

        return overAllProfit;
    }
}