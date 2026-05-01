class Solution {
    int count = 0;

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1'){
                    count(grid, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    private void count(char[][] grid, int i, int j, int n, int m){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0' || grid[i][j] == '#')return;
        grid[i][j] = '#';
        count(grid, i+1, j, n, m);
        count(grid, i-1, j, n, m);
        count(grid, i, j+1, n, m);
        count(grid, i, j-1, n, m);
    }
}