class Solution {
    int count = 0;

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    count(grid, vis, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    private void count(char[][] grid, boolean[][] vis, int i, int j, int n, int m){
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == '0')return;
        vis[i][j] = true;
        count(grid, vis, i+1, j, n, m);
        count(grid, vis, i-1, j, n, m);
        count(grid, vis, i, j+1, n, m);
        count(grid, vis, i, j-1, n, m);
    }
}