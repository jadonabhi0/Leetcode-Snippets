class Solution {
     long mod = 1000000007;
    public int countVowelPermutation(int n) {
        if(n == 1)
            return 5;
        
        long dp[][] = new long[6][n+1];
        for(int i = 1; i<=5;i++)
            dp[i][1] = 1;
        
        for(int j = 2; j<=n;j++) {
            dp[1][j] = dp[2][j-1];
            dp[2][j] = (dp[1][j-1] + dp[3][j-1])%mod;
            dp[3][j] = (dp[1][j-1] + dp[2][j-1] + dp[4][j-1] + dp[5][j-1])%mod;
            dp[4][j] = (dp[3][j-1] + dp[5][j-1])%mod;
            dp[5][j] = dp[1][j-1];
        }
        return (int)((dp[1][n] + dp[2][n] + dp[3][n] + dp[4][n] + dp[5][n])%mod);
    }
}