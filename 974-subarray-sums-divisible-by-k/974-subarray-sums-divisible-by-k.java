class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0; 
        int rem = 0;
        int count = 0;
        map.put(0,1);
        
        for(int i : nums){
            sum += i;
            rem = sum % k;
            if(rem < 0){
                rem += k;
            }
            if(map.containsKey(rem)){
                count += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            }else{
                map.put(rem, 1);
            }
        }
        return count;
    }
}