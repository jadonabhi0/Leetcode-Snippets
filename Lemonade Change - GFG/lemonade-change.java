//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean helper(int[] arr, int n){
        if(arr[0] != 5) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr){
            // if customer came with $5
            if(val == 5) map.put(5, map.getOrDefault(5, 0)+1);
            
            // if customer come  with $10
            else if(val == 10){
                if(map.getOrDefault(5, 0) > 0){
                    map.put(10, map.getOrDefault(10, 0)+1);
                    map.put(5, map.get(5)-1);
                }else return false;
            // if customer come with $20
            }else{
                if(map.getOrDefault(10, 0) > 0){
                    map.put(10, map.get(10)-1);
                    if(map.getOrDefault(5, 0) > 0){
                        map.put(5, map.get(5)-1);
                    }else return false;   
                }else if(map.getOrDefault(5, 0) >= 3){
                    map.put(5, map.get(5)-3);
                }else return false;
            }
        }
        return true;
    }
    static boolean lemonadeChange(int N, int bills[]) {
        
        return helper(bills, N);
    }
}
