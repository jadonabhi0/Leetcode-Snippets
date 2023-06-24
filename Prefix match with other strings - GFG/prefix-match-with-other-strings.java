//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.next();
            }
            
            int k = Integer.parseInt(sc.next());
            
            String str = sc.next();
            
            Solution obj = new Solution();
            int ans = obj.klengthpref(arr,n,k,str);
            System.out.println(ans);
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int klengthpref(String[] arr, int n, int k, String str)
    {
        if(str.length() < k) return 0;
        int ans = 0;
        for(String s : arr){
            boolean flag = true;
            int cnt = 0;
            for(int i = 0 ; i < Math.min(k, Math.min(s.length(), str.length())) ; i++){
                char c1 = s.charAt(i);
                char c2 = str.charAt(i);
                cnt++;
                if(c1 != c2){
                   flag = false; 
                   break;
                } 
            }
            if(flag && cnt == k) ans++;
        }
        return ans;
    }
}