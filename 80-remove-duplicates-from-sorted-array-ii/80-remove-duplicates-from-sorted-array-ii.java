class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        int ans = 0;
        int c = 0;
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            if(m.getValue() >= 2){
                ans += 2;
                nums[c++] = m.getKey();
                nums[c++] = m.getKey();
            }else{
                ans+=1;
                nums[c++] = m.getKey();
            }
        }
        return ans;
    }
}