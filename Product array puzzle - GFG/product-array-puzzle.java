//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n); 

           	for (int i = 0; i < n; i++) { 
				System.out.print(ans[i]+" ");
			} 
            System.out.println();
            t--;
        }
    } 
} 
  


// } Driver Code Ends


//User function Template for Java


class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int nn) 
	{ 
        // code here
        long n = 1;
        long[] array = new long[nn];
        array[0] = 1;
        for(int i = 1 ; i < nn ; i++){
            n = n * nums[i-1];
            array[i] = n;
        }
        
        n = 1;
        
        for(int i = nn-1 ; i >= 0 ; i--){
            array[i] = array[i]*n;
            n = n*nums[i];
        }
        
        return array;
	} 
} 
