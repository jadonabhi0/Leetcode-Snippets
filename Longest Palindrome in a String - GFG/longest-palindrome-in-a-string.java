//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        String s = S;
    boolean[][] dp = new boolean[s.length()][s.length()];
        int st = 0;
        int end = 0;
        for(int g = 0 ; g < s.length() ; g++){
            for(int j = g ,i = 0 ; j < s.length() ; i++, j++){
                if(g == 0) dp[i][j] = true;
                else if(g == 1) dp[i][j] = s.charAt(i) == s.charAt(j);
                else dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                if(dp[i][j]){
                if(g == 0){
                    st = 0;
                    end = 1;
                }else{
                    if(end < g+1){
                        end = g+1;
                        st = i;
                    }
                }
            }
            }
            
        }
        String ans = "";
        for(int i = 0 ; i < end ; i++){
            ans += s.charAt(st++);
        }
        return ans;
        
    }
}