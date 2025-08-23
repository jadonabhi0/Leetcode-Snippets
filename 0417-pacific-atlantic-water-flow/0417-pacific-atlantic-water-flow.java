class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] at = new boolean[n][m]; // atlantic visited
        boolean[][] pt = new boolean[n][m]; // pacific visited

        // dfs call for verfical rows
        for(int i = 0 ; i < n ; i++){
            dfs(heights, pt, i, 0, n, m, Integer.MIN_VALUE); // call for pacific
            dfs(heights, at, i, m - 1, n, m, Integer.MIN_VALUE); // call for atlantic
        }

         // dfs call for horizantal rows
        for(int i = 0 ; i < m ; i++){
            dfs(heights, pt, 0, i , n, m, Integer.MIN_VALUE); // call for pacific
            dfs(heights, at, n-1, i, n, m, Integer.MIN_VALUE); // call for atlantic
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pair = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(at[i][j] && pt[i][j]){
                    pair.add(i);
                    pair.add(j);
                    ans.add(new ArrayList<>(pair));
                    pair.clear();
                }
            }
        }
        return ans;
    }


    private void dfs(int[][] ht, boolean[][] vis, int i, int j, int row, int col, int preVal){

        if(i < 0 || i == row || j < 0|| j == col || vis[i][j] || preVal > ht[i][j]) return;

        vis[i][j] = true;

        dfs(ht, vis, i + 1, j, row, col, ht[i][j]);
        dfs(ht, vis, i - 1, j, row, col, ht[i][j]);
        dfs(ht, vis, i, j + 1, row, col, ht[i][j]);
        dfs(ht, vis, i, j - 1, row, col, ht[i][j]);

    }
}