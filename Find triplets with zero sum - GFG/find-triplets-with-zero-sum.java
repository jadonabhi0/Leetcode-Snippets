//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        Arrays.sort(arr);
        for(int i = 0 ; i < n-2 ; i++){
            int lo = i+1, hi = n-1;
            int c = arr[i];
            while(lo < hi){
                int a = arr[lo];
                int b = arr[hi];
                if(a+b+c == 0) return true;
                // while(lo < hi && arr[lo] == arr[lo+1]) lo++;
                // while(lo < hi && arr[hi] == arr[hi-1]) hi--;
                
                if(a+b+c > 0) hi--;
                else lo++;
            }
        }
        return false;
    }
}