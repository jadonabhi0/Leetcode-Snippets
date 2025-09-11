class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];

        int start = 0;
        int maxLen = 1;;

        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(isPallindrome(s, i, j, dp)){
                    if(j-i+1 > maxLen){
                        start = i;
                        maxLen = j-i+1;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);

    }


    private boolean isPallindrome(String s, int i , int j, Boolean[][] dp){
        if(j <= i) return true;

        if(dp[i][j] != null) return dp[i][j];


        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = isPallindrome(s, i+1, j-1, dp);
        }else{
            dp[i][j] = false;
        }

        return dp[i][j];
    }
}