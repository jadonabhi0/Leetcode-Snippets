class Solution {
    public int minDistance(String str1, String str2) {
         if (str1.equals(str2)) {
            return 0;
        }
        if (str1.length() == 0 || str2.length() == 0) {
            return Math.abs(str1.length() - str2.length());
        }
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= str2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        // for(int[] i : dp){
        //     System.out.println(Arrays.toString(i));
        // }
        return dp[str1.length()][str2.length()];
    }
}