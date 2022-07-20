class Solution {
    public  int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        for(int i = 0 ; i < col ; i++){
            dp[row-1][i] = matrix[row-1][i];
        }
        
        for(int i = row-2 ; i >= 0 ; i--){
            for(int j = col-1 ; j >= 0 ; j--){
                if(j == 0){
                    dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + matrix[i][j];
                }else if(j == dp[i].length-1){
                    dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j-1]) + matrix[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i+1][j], Math.min(dp[i+1][j-1], dp[i+1][j+1])) + matrix[i][j];
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < col ; i++){
            min = Math.min(min, dp[0][i]);
        }

        return min;
    }
}