class Solution {
    public int numDistinct(String s1, String s2) {
         int[][] dp = new int[s2.length()+1][s1.length()+1];

        for(int i = 0 ; i <= s1.length() ; i++){
            dp[0][i] = 1;
        }
        // System.out.println(Arrays.toString(dp[0]));
        for(int i = 0 ; i < s2.length() ; i++){
            for(int j = 0 ; j < s1.length() ; j++){
                if(s1.charAt(j) == s2.charAt(i)){
                    dp[i+1][j+1] = dp[i+1][j] + dp[i][j];
                }else{
                    dp[i+1][j+1] = dp[i+1][j];
                }
            }
            // System.out.println(Arrays.toString(dp[i]));
        }
        return dp[s2.length()][s1.length()];
    }
}