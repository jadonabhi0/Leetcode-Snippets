class Solution {
    public int minimumDeleteSum(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i = dp.length-1 ; i >= 0 ; i--){
            for(int j = dp[0].length-1 ; j >= 0 ; j--){
                if(i == dp.length-1 && j == dp[0].length-1){
                    dp[i][j] = 0;
                }else if(i == dp.length-1){
                    dp[i][j] = dp[i][j+1] + str2.charAt(j);
                }else if(j == dp[0].length-1){
                    dp[i][j] = dp[i+1][j] + str1.charAt(i);
                }else{
                    if(str1.charAt(i) == str2.charAt(j)){
                        dp[i][j] = dp[i+1][j+1];
                    }else{
                        dp[i][j] = Math.min(dp[i][j+1]+str2.charAt(j), dp[i+1][j]+str1.charAt(i));
                    }
                }
            }
        }
        return dp[0][0];
    }
}