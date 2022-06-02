class Solution {
    public int[][] transpose(int[][] matrix) {
        int ans[][] = new int[matrix[0].length][matrix.length]; //result matrix (w/ size from transposition)
        for(int i = 0; i<matrix.length; i++)
            for(int j = 0; j<matrix[0].length; j++)
                ans[j][i] = matrix[i][j]; //transpose
        return ans;
    }
}