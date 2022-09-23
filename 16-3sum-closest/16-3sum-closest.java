class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length ; i++){
            int a = nums[i];
            int l = i+1;
            int r = nums.length-1;
            while(l < r){
                int sum = a + nums[l] + nums[r];
                     
              if(Math.abs(target - sum) < Math.abs(min)){
                   min = target - sum;
              }
             if(target < sum)r--;
             else l++;
               
            }
        }
        return target - min;
    }
}