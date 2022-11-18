//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int nn) {
        // code here
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> n = new ArrayList<>();
        for(int i : arr){
            if(i >= 0) p.add(i);
            else n.add(i);
        }
        int c = 0;
        
        while(p.size() > 0 && n.size() > 0){
            arr[c++] = p.remove(0);
            arr[c++] = n.remove(0);
        }
        
        if(p.size() > 0){
            while(p.size() != 0){
               arr[c++] = p.remove(0); 
            }
        }
        
        if(n.size() > 0){
            while(n.size() != 0){
               arr[c++] = n.remove(0); 
            }
        }
    }
}