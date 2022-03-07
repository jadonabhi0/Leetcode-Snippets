class Solution {
    static int index = 0;
    public int search(int[] nums, int target) {
       int low = 0;
       int high = nums.length-1;
       while(low<=high){
           if(nums[low] == target) return low;
           else if(nums[high] == target) return high;
           else{low++;high--;}
       }
        return -1;
    } 
}