class Solution {
    
   
    
    public int coinChange(int[] array, int tar) {
        
        int[] dp = new int[tar + 1];
        dp[0] = 0;
        for(int i = 1 ; i < dp.length ; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0 ; j < array.length ; j++){
                if(i>= array[j] && dp[i-array[j]] != -1){
                    min = Math.min(min, dp[i-array[j]]);
                }
               
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min+1;
        }
        return dp[tar];
    }
}