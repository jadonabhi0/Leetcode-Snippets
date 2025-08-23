class Solution {
    public int numIslands(char[][] grid) {
        int count=0, n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, vis, i, j, n, m);
                }
            }
        }
        return count;
    }


    private void dfs(char[][] grid, int[][] vis, int row, int col, int n, int m){

        if(row < 0 || row >= n || col < 0 || col >= m || vis[row][col] == 1 || grid[row][col] == '0') return ;

        vis[row][col] = 1;
        grid[row][col] = '0';
        dfs(grid, vis, row-1, col, n, m);
        dfs(grid, vis, row, col-1, n, m);
        dfs(grid, vis, row+1, col, n, m);
        dfs(grid, vis, row, col+1, n, m);

    }
}