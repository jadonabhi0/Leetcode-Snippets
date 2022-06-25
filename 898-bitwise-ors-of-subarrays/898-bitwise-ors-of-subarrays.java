class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        
         Set<Integer> ans  = new HashSet<>();
         Set<Integer> prev  = new HashSet<>();
         Set<Integer> cur;
        
        for(int val : arr){
            cur = new HashSet<>();
            prev.add(0);
            
            for(int i : prev){
                cur.add(i | val);
                ans.add(i | val);
            }
            
            prev = cur;
        }
        
      return ans.size();  
    }
}