class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    ans = Math.max(ans, dfs(grid, i, j, n, m));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int row, int col, int n, int m){

        if(row < 0 || row >= n || col < 0 || col >= m  || grid[row][col] == 0) return 0;
        grid[row][col] = 0;

        int area = 1;
        area += dfs(grid, row-1, col, n, m);
        area += dfs(grid, row, col-1, n, m);
        area += dfs(grid, row+1, col, n, m);
        area += dfs(grid, row, col+1, n, m);

        return area;

    }
}