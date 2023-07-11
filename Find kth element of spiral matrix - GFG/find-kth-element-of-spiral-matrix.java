//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
  public static int findK(int[][] matrix, int n, int m, int k) {
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;
        int direction = 0; // 0: left to right, 1: top to bottom, 2: right to left, 3: bottom to top

        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    k--;
                    if (k == 0) {
                        return matrix[top][i];
                    }
                }
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    k--;
                    if (k == 0) {
                        return matrix[i][right];
                    }
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    k--;
                    if (k == 0) {
                        return matrix[bottom][i];
                    }
                }
                bottom--;
            } else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    k--;
                    if (k == 0) {
                        return matrix[i][left];
                    }
                }
                left++;
            }
            direction = (direction + 1) % 4; // update direction
        }

        return -1; // Return -1 if k is out of bounds or matrix is empty
}}