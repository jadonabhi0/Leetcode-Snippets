class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] ar1 = text1.toCharArray();
        char[] ar2 = text2.toCharArray();
        int l1 = ar1.length;
        int l2 = ar2.length;
        int[][] dp = new int[l1+1][l2+1];  
        int lcs = 0;
        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1 ; j < dp[i].length ; j++){
                if(ar1[i-1] == ar2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                   dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
                if(dp[i][j] > lcs){
                    lcs = dp[i][j];
                }
            }
        }
        return lcs;
    }
}