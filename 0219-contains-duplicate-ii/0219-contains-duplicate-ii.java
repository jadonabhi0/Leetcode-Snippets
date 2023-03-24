class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0  ; i < nums.length ; i ++){
            if(map.containsKey(nums[i])){
                int n = map.get(nums[i]);
                if(i-n < k) return true;
            }
            map.put(nums[i],i+1);   
        }
        return false;
    }
}
