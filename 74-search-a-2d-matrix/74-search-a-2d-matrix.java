class Solution {
     public static boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        for(int i = 0 ; i < len ; i++) {
            int low = 0;
            int high = matrix[i].length-1;
            while (low <= high) {
                int mid = (high + low) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}