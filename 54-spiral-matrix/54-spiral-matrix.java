class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int upperrow  = 0;
        int lowerrow = matrix.length;
        int leftcol = 0;
        int rightcol = matrix[0].length;
        List<Integer> list = new LinkedList<>();
        
        while(list.size() != matrix.length*matrix[0].length){
            for(int i = leftcol ; i < rightcol-1 ; i++ ){
                if(list.size() == matrix.length*matrix[0].length) return list;
                list.add(matrix[upperrow][i]);
            }
            for(int i = upperrow ; i <= lowerrow-1 ; i++ ){
                if(list.size() == matrix.length*matrix[0].length) return list;
                list.add(matrix[i][rightcol-1]);
            }
            for(int i = rightcol-2 ; i > leftcol ; i-- ){
                if(list.size() == matrix.length*matrix[0].length) return list;
                list.add(matrix[lowerrow-1][i]);
            }
            for(int i = lowerrow-1 ; i > upperrow ;i--){
                if(list.size() == matrix.length*matrix[0].length) return list;
                list.add(matrix[i][leftcol]);
            }
            leftcol++;
            rightcol--;
            upperrow++;
            lowerrow--;
            }
        return list;
    }
}