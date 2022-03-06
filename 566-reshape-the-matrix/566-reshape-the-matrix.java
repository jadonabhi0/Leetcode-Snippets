class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        if(mat.length*mat[0].length != r*c) return mat;
        int[] array = new int[mat.length*mat[0].length];
        int[][] res = new int[r][c];
        int count = 0 ;
        for(int i = 0 ; i < mat.length ;i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                array[count++] = mat[i][j];
            }
        }
        count = 0 ;
        for(int i = 0 ; i < res.length ; i++){
            for(int j = 0 ; j < res[0].length ; j++){
                res[i][j] = array[count++];
            }
        }
        return res;
    }
}