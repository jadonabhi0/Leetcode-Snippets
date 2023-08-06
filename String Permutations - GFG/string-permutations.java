//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    ArrayList<String> ans;
    public void helper(String s, String per){
        if(s.length() == 0){
            ans.add(per);
            return;
        }
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            helper(s.substring(0, i)+s.substring(i+1), per+ch);
        }
    }
    
    public ArrayList<String> permutation(String S)
    {
        ans = new ArrayList<>();
        helper(S, "");
        Collections.sort(ans);
        return ans;
    }
	   
}
