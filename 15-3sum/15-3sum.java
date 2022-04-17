class Solution {
   public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        if (nums.length < 3) {
            return  ans;
        }
        for(int i = 0 ; i < nums.length-2 ; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i+1;
            int high = nums.length-1;
            int tar = -nums[i];
            while(low < high){
                if(nums[low] + nums[high] == tar){
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    set.add(list);
                    list = new ArrayList<>();
                    while (low < high && nums[low+1] == nums[low]) low++;
                    while (low < high && nums[high-1] == nums[high]) high--;
                    low++;
                    high--;
                }
                else if(tar > nums[low]+nums[high]) low++;
                else high--;
            }
        }

        for(List<Integer> l : set){
            ans.add(l);
        }
        return ans;
    }
}