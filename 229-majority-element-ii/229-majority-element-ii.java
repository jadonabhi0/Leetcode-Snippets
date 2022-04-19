class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
         int n = len/3;
        
        for(Map.Entry<Integer , Integer> m : map.entrySet()){
            if(m.getValue() > n){
                list.add(m.getKey());
            }
        }
        return list;
    }
}