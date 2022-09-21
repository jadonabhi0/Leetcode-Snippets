class Solution {
    List<List<Integer>> list = new LinkedList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int a = nums[i];
            int left = i+1;
            int right = nums.length-1 ;
            while(left < right){
                if(nums[left] + nums[right] == -a){
                    list.add(Arrays.asList(a, nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(nums[left] + nums[right] > -a) right--;
                else if(nums[left] + nums[right] < -a) left++;
            }    
        }
        return list;
    }
}