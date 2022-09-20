class Solution {
    public int[] twoSum(int[] nums, int tar) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] array = new int[2];
        map.put(nums[0], 0);
        for(int i = 1; i < nums.length ; i++){
            int n = tar - nums[i];
            if(map.containsKey(n)){
                array[0] = map.get(n);
                array[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return array;
    }
}