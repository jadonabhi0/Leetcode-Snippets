class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> ans = new ArrayList<>();
        solve(board, 0, n, ans);
        return ans;
    }

    private void solve(char[][] board, int col, int n, List<List<String>> ans) {
        if (col == n) {
            ans.add(buildAns(board, n));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isValidPos(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, col + 1, n, ans);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isValidPos(char[][] board, int row, int col) {
        // check left row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') return false;
        }

        // check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // check lower-left diagonal
        for (int i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> buildAns(char[][] board, int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new String(board[i]));
        }
        return ans;
    }
}
