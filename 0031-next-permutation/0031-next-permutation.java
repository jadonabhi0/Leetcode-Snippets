class Solution {
    public void nextPermutation(int[] nums) {

       int ind = findBreakPoint(nums);

       if(ind == -1){
        reverse(nums, 0, nums.length-1);
        return;
       }

       for(int i = nums.length-1 ; i >= 0 ; i--){
            if(nums[i] > nums[ind]){
                swap(nums, ind, i);
                break;
            }
       }

       reverse(nums, ind+1, nums.length-1);
        
    }


    private int findBreakPoint(int[] nums){

        for(int i = nums.length-2 ; i >= 0 ; i--){
            if(nums[i] < nums[i+1]){
                return i;
            }
        }

        return -1;
    }

    private void swap(int[] nums, int i, int j){
       int holder = nums[i];
       nums[i] = nums[j];
       nums[j] = holder;
    }

    private void reverse(int[] nums, int i, int j){
       while(i < j){
        swap(nums, i, j);
        i++;
        j--;
       }
    }

}