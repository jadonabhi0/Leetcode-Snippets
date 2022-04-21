class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] array : matrix){
            int low = 0;
            int high = array.length-1;
            while(low <= high){
                int mid = (low+high)/2;
                if(array[mid] == target) return true;
                else if(array[mid] > target){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }
        return false;
    }
}