class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        if(target == 0) return 1;
        if(map.containsKey(target)) return map.get(target);
        int ans = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(target >= nums[i]){
                ans += combinationSum4(nums, target - nums[i]);
                map.put(target, ans);
            }
        }
        return ans;
    }
}