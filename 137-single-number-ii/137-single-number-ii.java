class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
       Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            if(m.getValue() == 1) ans = m.getKey();
        }
        return ans;
    }
}