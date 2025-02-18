class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int len = grid.length;

        // sorting the lower left
        for(int a = 0 ; a < len ; a++){
            for(int i = a, j = 0 ; i < len ; i++, j++){
                for(int n = i + 1, m = j+1 ; n < len ; n++, m++){
                    if(grid[i][j] < grid[n][m]){
                        int temp = grid[i][j];
                        grid[i][j] = grid[n][m];
                        grid[n][m] = temp;
                    }

                }

            }
        }


        // sorting the upper right
        for(int a = 1 ; a < len ; a++){
            for(int i = 0, j = a ; j < len ; i++, j++){
                for(int n = i+1, m = j+1 ; m < len ; n++, m++){
                    if(grid[i][j] > grid[n][m]){
                        int temp = grid[i][j];
                        grid[i][j] = grid[n][m];
                        grid[n][m] = temp;
                    }
                }
            }
        }


        return grid;
    }
}