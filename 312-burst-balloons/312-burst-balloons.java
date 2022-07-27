class Solution {
    
    public int maxCoins(int[] array) {
        
        int [][] dp = new int[array.length][array.length];
        for(int g = 0 ; g < dp.length ; g++){
            for(int i = 0 , j = g ; j < dp.length ; j++, i++){
                int max  = Integer.MIN_VALUE;
                for(int k = i ; k <= j ; k++){
                    int left = k == i ? 0 : dp[i][k-1];
                    int right = k == j ? 0 : dp[k+1][j];
                    int val = (i == 0 ? 1 : array[i-1]) * array[k] * (j == array.length-1 ? 1 : array[j+1]);
                    int total = left + right + val;
                    max = Math.max(max, total);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][dp.length-1];
        
        
    }
}