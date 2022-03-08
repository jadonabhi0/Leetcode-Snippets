class Solution {
    public boolean isValidSudoku(char[][] board) {
        //validate rows and cols
        Set<Character> rowCheck = new HashSet<>();
        Set<Character> colCheck = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            rowCheck = new HashSet<>();
            colCheck = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.' && !rowCheck.add(board[row][col]))
                    return false;
            
                if (board[col][row] != '.' && !colCheck.add(board[col][row]))
                    return false;
            }
        }
        
        //validate boxes
        for (int row = 0; row < 9; row+=3) {
            for (int col = 0; col < 9; col+=3) {
                if (!boxCheck(board, row, col))
                    return false;
            }
        }
        
        return true;        
    }
    
    private boolean boxCheck(char[][] board, int startRow, int startCol) {
        Set<Character> boxCheck = new HashSet<>();
        for (int i=startRow; i<startRow+3;i++) {
            for (int j=startCol; j<startCol+3;j++) {
                if (board[i][j] != '.' && !boxCheck.add(board[i][j]))
                    return false;
            }
        }
        return true;
    }
}