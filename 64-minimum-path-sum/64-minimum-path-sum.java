class Solution {
    
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] array = new int[row][col];
       
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
               if(i == 0 && j == 0){
                   array[i][j] = grid[i][j];
               }else if(i == 0){
                   array[i][j] = grid[i][j]+array[i][j-1];
               }else if(j == 0){
                   array[i][j] = grid[i][j]+array[i-1][j];
               }else{
                   array[i][j] = grid[i][j]+Math.min(array[i-1][j],array[i][j-1]);
               }
            }
        }
       
        return array[row-1][col-1];
    }
}