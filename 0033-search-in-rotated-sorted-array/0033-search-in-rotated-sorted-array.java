class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;
        int lo = 0 , hi = n-1;

        while(lo <= hi){

            int mid = (lo + hi) / 2;

            if(nums[mid] == target) return mid;

            // left half part is sorted
            if(nums[lo] <= nums[mid]){
                if(nums[lo] <= target && target <= nums[mid]) hi = mid-1;
                else lo = mid+1;
            }else if(nums[mid] <= nums[hi]){ // right half part is sorted
               if(target >= nums[mid] && target <= nums[hi]) lo = mid+1;
               else hi = mid - 1;
            }

        }

        return -1;
        
    }
}