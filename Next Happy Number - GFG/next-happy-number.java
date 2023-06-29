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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static boolean helper(int n){
        if(n == 1 || n == 7) return true;
        int sum = Integer.MAX_VALUE;
        int cur = n;
        
        while(sum > 9){
            sum = 0;
            while(cur > 0){
                sum += Math.pow(cur%10, 2);
                cur /= 10;
            }
            if(sum == 1) return true;
            cur = sum;
        }
        
        if(sum == 7) return true;
        return false;
    }

    static int nextHappy(int N){
        int n = N+1;
        while(true){
            if(helper(n)) return n;
            n++;
        }
    }
}