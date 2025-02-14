class Solution {
    public int removeElement(int[] nums, int val) {

        int n = nums.length, cnt = n, right = n-1;

        for(int i = 0 ; i <= right && i < n ; i++){

            while(right >= 0 && nums[right] == val){
                cnt--; right--;
            }

            if(i <= right && nums[i] == val){
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
                cnt--;
            }
        }
        
        return cnt;
    }
}