class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp = n-1;
        int[][] array = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                array[j][temp] = matrix[i][j];
                
            }
            temp--;
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                matrix[i][j] = array[i][j];
            }
        }
    }
}