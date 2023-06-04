//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseEqn(String S)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = S.length()-1 ; i >= 0 ; i--){
            char ch = S.charAt(i);
            if(sb.length() == 0) sb.append(ch);
            else if(ch == '*' || ch == '/' || ch == '-' || ch == '+') sb.append(ch);
            else{
                if(sb.length()>0){
                    char c = sb.charAt(sb.length()-1);
                    if(c == '*' || c == '/' || c == '-' || c == '+') sb.append(ch);
                    else sb.insert(sb.length()-1, ch);
                }
            }
        }
        return sb.toString();
    }
}