class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        // Step 1: Mark safe O's starting from boundary
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') dfs(board, vis, i, 0, n, m);
            if (board[i][m - 1] == 'O') dfs(board, vis, i, m - 1, n, m);
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') dfs(board, vis, 0, j, n, m);
            if (board[n - 1][j] == 'O') dfs(board, vis, n - 1, j, n, m);
        }

        // Step 2: Flip internal O's
        for (int i = 1; i < n -1; i++) {
            for (int j = 1; j < m-1; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] vis, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || board[i][j] == 'X') return;

        vis[i][j] = true;

        dfs(board, vis, i + 1, j, n, m);
        dfs(board, vis, i - 1, j, n, m);
        dfs(board, vis, i, j + 1, n, m);
        dfs(board, vis, i, j - 1, n, m);
    }
}
