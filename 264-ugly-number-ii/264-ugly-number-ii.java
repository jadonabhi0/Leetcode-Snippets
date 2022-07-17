class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        
        int p1 = 1;
        int p2 = 1;
        int p3 = 1;
        
        for(int i = 2 ; i <= n ; i++){
            int f1 = dp[p1] * 2;
            int f2 = dp[p2] * 3;
            int f3 = dp[p3] * 5;
            
            dp[i] = Math.min(f1, Math.min(f2, f3));
            
            if(dp[i] == f1) p1++;
            if(dp[i] == f2) p2++;
            if(dp[i] == f3) p3++;
        }
        return dp[n];
    }
}