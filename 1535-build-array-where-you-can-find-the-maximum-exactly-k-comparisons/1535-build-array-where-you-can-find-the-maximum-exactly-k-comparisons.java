class Solution 
{
    public int numOfArrays(int n, int m, int k) 
    {
        int[][][] dp = new int[n + 1][m + 1][k + 1];
        for(int[][] cols : dp)
        for(int[] rows : cols)
        Arrays.fill(rows, -1);
        return calculate(n, m, k, 0, 0, 0, dp);
    }
    int calculate(int n, int m, int k, int i, int currMax, int currCost, int[][][] dp) 
    {
        if (i == n) // Base Case
        {
            if (k == currCost)
                return 1; 
            else
                return 0;
        }

        if (dp[i][currMax][currCost] != -1) //Memoization Check Step
            return dp[i][currMax][currCost];

        int ans = 0;
        for (int num = 1; num <= m; num++) 
        {
            int newCost = currCost;
            int newMax = currMax;
            if (num > currMax) 
            {
                newCost++;
                newMax = num;
            }
            if (newCost > k)
            {
                break;
            }

            ans = ans + calculate(n, m, k, i + 1, newMax, newCost, dp); // Recursive call
            ans = ans % (int)(Math.pow(10,9) + 7); // Doing Modulo of Answer
        }
        return dp[i][currMax][currCost] = ans; // Storing Values in DP
    }
}