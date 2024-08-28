class Solution {
    int ans = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int result = 0;
        for(int i = 0 ; i < grid2.length ; i++){
            for(int j = 0 ; j < grid2[0].length ; j++){
                if(grid2[i][j] == 1){
                    ans = 1;
                    dfs(grid1, grid2, i, j);
                    result += ans;
                }
            }
        }
        return result;
    }

    public void dfs(int[][] grid1, int[][] grid2, int row, int col){
        if(row < 0 || row == grid2.length || col < 0 || col == grid2[0].length || grid2[row][col] == 0) return ;
        if(grid1[row][col] == 0) ans = 0;
        grid2[row][col] = 0;
        dfs(grid1, grid2, row-1, col);
        dfs(grid1, grid2, row+1, col);
        dfs(grid1, grid2, row, col-1);
        dfs(grid1, grid2, row, col+1);
    }
}