class Solution {
    
     public static int helper(String str){
        boolean[][] strg = new boolean[str.length()][str.length()];
        for(int g = 0 ; g < str.length() ; g++){
            for(int i = 0 , j = g ; j < str.length() ; i++, j++){
                if (g == 0){
                    strg[i][j] = true;
                }else if(g == 1){
                    strg[i][j] = str.charAt(i) == str.charAt(j);
                }else{
                    if(str.charAt(i) == str.charAt(j) && strg[i+1][j-1]){
                        strg[i][j] = true;
                    }else{
                        strg[i][j] = false;
                    }
                }
            }
        }

        // for (boolean[] b : strg) System.out.println(Arrays.toString(b));

        int [] dp = new int[str.length()];
        dp[0] = 0;
        int min = 0;
        for(int j = 1 ; j < str.length() ; j++){
            if (strg[0][j]){
                dp[j] = 0;
            }else{
                min = Integer.MAX_VALUE;
                for(int i = j ; i >= 1 ; i--){
                    if(strg[i][j]){
                        min = Math.min(dp[i-1], min);
                    }
                }
                dp[j] = min+1;
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[str.length()-1];
    }
    
    public int minCut(String s) {
        return helper(s);
    }
}