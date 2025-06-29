class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board.length ; j++){

                if(board[i][j] == '.'){

                    for(char num = '1' ; num <= '9' ; num++){

                        if(isValidPos(board, i, j, num)){
                            board[i][j] = num;
                            if(solve(board)) return true;
                            else board[i][j] = '.'  ;                              
                        }

                    }
                    return false;

                }

            }
        }
        return true;
        
    }


    private boolean isValidPos(char[][] board, int i, int j, char num){

        // check row
        for(int col = 0; col < board.length ; col++){
            if(board[i][col] == num) return false;
        }

         // check col
        for(int row = 0; row < board.length ; row++){
            if(board[row][j] == num) return false;
        }

        // check 3x3 subgrid
        int startRow = 3 * (i / 3);
        int startCol = 3 * (j / 3);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[startRow + row][startCol + col] == num) return false;
            }
        }


        return true;
    }

}