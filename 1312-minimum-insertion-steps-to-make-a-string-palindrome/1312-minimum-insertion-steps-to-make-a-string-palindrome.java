class Solution {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int omax = 0;
        for(int g = 0 ; g < dp.length ; g++){
            for(int i = 0 , j = g ; j < dp.length ; j++, i++){
                if(g == 0){
                    dp[i][j] = 1;
                }else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                }else {
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 2 + dp[i+1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                    }
                }
                omax = Math.max(omax, dp[i][j]);
            }
        }
        int len = s.length();
        return len - omax;
    }
}