class Solution {
    List<List<Integer>> list = new LinkedList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4) return list;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++){ // finding first element.
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1 ; j < nums.length ; j++){ // finding second element.
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                long t = (long)target - nums[i] - nums[j];
                int k = j+1;
                int l = nums.length-1;
                while(k < l){
                    if(nums[k] + nums[l] == t){
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while(k < l && nums[k] == nums[k+1]) k++;
                        while(k < l && nums[l] == nums[l-1]) l--;
                        k++;
                        l--;
                    }
                    else if(nums[l] + nums[k] > t) l--;
                    else k++;
                }
            }
        }
        return list;
    }
}