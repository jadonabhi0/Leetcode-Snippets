class Solution {
    public int nthUglyNumber(int n) {
        int [] dp = new int[n+1];
        dp[1] = 1;

        int c1 = 1, c2 = 1, c3 = 1;

        for(int i = 2 ; i <= n ; i++){
            int n1 = 2 * dp[c1];
            int n2 = 3 * dp[c2];
            int n3 = 5 * dp[c3];

            dp[i] = Math.min(n1, Math.min(n2, n3));

            if(dp[i] == n1){
                c1++;
            }
            if(dp[i] == n2){
                c2++;
            }
            if(dp[i] == n3){
                c3++;
            }
        }
        System.out.print(Arrays.toString(dp));
        return dp[n];
    }
}
