class Solution {
    
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        if(nums.length<3) return list;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-2 ; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int a = nums[i];
            int low = i+1;
            int high = nums.length-1;
            while(low < high){
                if(nums[low]+nums[high] == -a){
                    list.add(Arrays.asList(a,nums[low],nums[high]));
                    while(low < high && nums[high] == nums[high-1]) high--;
                    while(low < high && nums[low] == nums[low+1]) low++;
                    low++;
                    high--;
                }
                else if(nums[low]+nums[high] > -a) high--;
                else if(nums[low]+nums[high] < -a) low++;
            }
        }
        return list;
    }
}