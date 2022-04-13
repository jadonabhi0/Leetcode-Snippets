class Solution {
    
    static void fill(int[][] m , int i , int j , int row , int col){

        // FILL ZEROS IN ROW
        for(int a = 0 ; a < row ; a++){
            m[a][j] = 0;

        }

        // FILL ZEROS IN COLUMN
        for(int b = 0 ; b < col ; b++){
            m[i][b] = 0;
        }
        
    }

    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] array = new int[row][col];

        
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                array[i][j] = matrix[i][j];
            }
        }

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(matrix[i][j] == 0){
                    fill(array,i,j,row,col);
                }
            }
        }
       
          for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                matrix[i][j] = array[i][j];
            }
        }
        

    }
}