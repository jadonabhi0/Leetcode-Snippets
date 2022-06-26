class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        
        boolean[][] dp = new boolean[m+1][n+1];
        
        int row = dp.length;
        int col = dp[0].length;
        
        for(int i = row -1 ; i >= 0 ; i--){
            for(int j = col -1 ; j >= 0 ; j--){
                
                // filling the dp array;
                
                if(i == row -1 && j == col -1){
                    
                    dp[i][j] = true;
                    
                }else if(i == row -1){
                    
                    dp[i][j] = false;
                    
                }else if(j == col -1){
                    
                    if(p.charAt(i) == '*'){
                        dp[i][j] = dp[i+1][j];
                    }else{
                        dp[i][j] = false;
                    }
                    
                }else{
                    
                    if(p.charAt(i) == '?'){
                        dp[i][j] = dp[i+1][j+1]; // check diagonal
                    }else if(p.charAt(i) == '*'){
                        dp[i][j] = dp[i+1][j] || dp[i][j+1];
                    }else if(p.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j+1]; // check diagonal
                    }else{
                        dp[i][j] = false;
                    }
                    
                    
                }
                
            }
        }
        return dp[0][0];
    }
}