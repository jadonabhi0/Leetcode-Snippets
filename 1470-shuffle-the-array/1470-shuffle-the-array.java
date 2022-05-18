class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] array = new int[2*n];
        int c = 0;
        
        for(int i = 0 ,j = n ; i < n ; i++, j++ ){
            array[c++] = nums[i];
            array[c++] = nums[j];
        }
        return array;
    }
}