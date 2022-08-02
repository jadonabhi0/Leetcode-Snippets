class Solution {
    
    public static int helper(int egg, int floor){
        int [][] dp = new int[egg+1][floor+1];

        for(int i = 1 ; i <= egg ; i++){
            for(int j = 1 ; j <= floor ; j++){
                if(i == 1) dp[i][j] = j;
                else if(j == 1) dp[i][j] = 1;
                else{
                    int min = Integer.MAX_VALUE;
                    for(int mj = j-1, pj = 0 ; mj >= 0 ; mj--, pj++){
                        int v1 = dp[i][mj];
                        int v2 = dp[i-1][pj];
                        int val = Math.max(v1, v2);
                        min = Math.min(min, val);
                    }
                    dp[i][j] = min + 1;
                }

            }
        }
        return dp[egg][floor];
    }
    
    public int twoEggDrop(int n) {
        return helper(2, n);
    }
}