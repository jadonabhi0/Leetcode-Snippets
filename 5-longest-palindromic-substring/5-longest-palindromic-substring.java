class Solution {
    public static String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int start = 0 ;
        int max = 0;
        for(int g = 0 ; g < s.length() ; g++){
            for(int i = 0,  j = g ; j < s.length() ; j++,i++){
                if(g == 0){
                    dp[i][j] = true;
                }else if(g == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                
                
                if(dp[i][j]){
                    if(g == 0){
                        start = 0;
                        max = 1;
                    }else {
                        if(max < g+1){
                            max = g+1; 
                            start = i;
                        }
                    }
                }
                
                
            }
        }
        
        String ans = "";
        for(int i = 0 ; i < max ; i++){
            ans += s.charAt(start++);
        }
        return ans;
    }
}