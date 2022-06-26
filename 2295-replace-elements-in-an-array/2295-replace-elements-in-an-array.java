class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map =new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i],i);
        }
        
        
        for(int i = 0 ; i < operations.length ; i++){
            int a = operations[i][0];
            int b = operations[i][1];
            
            if(map.containsKey(a)){
                nums[map.get(a)] = b;
            }
            map.put(b,map.get(a));
        }
        
        return nums;
    }
}