class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int row = image.length;
        int col = image[0].length;
        int t = col-1;
        
        int[][] array = new int[row][col];
        
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                array[i][t--] = image[i][j];
            }
            t = col-1;
        }
        
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(array[i][j] == 1){
                    array[i][j] = 0;
                }else{
                    array[i][j] = 1;
                }
            }
        }
        return array;
    }
}