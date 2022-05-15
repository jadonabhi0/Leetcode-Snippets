class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        
        for(Map.Entry<Integer, Integer> m : map.entrySet()) {
             if(m.getValue() > 1){
                 list.add(m.getKey());
             }
         }        
        return list;
    }
}