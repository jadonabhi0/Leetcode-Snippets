//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }
// } Driver Code Ends


class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if(low >= high) return;
        int pidx = partition(arr, low, high);
        quickSort(arr, low, pidx-1);
        quickSort(arr, pidx+1, high);
    }
    
    static int partition(int arr[], int low, int high)
    {
        int i = low, j = high;
        int piv = arr[low];
        while(i < j){
            
            while(arr[i]<= piv && i < high) i++;
            while(arr[j] > piv && j >= low) j--;
            if(i < j)swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    } 
    
    static void swap(int[] ar, int i, int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
