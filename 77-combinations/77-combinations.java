class Solution {
    
    public static List<List<Integer>> comb(int n,  int k, List<Integer> list, List<List<Integer>> ans){
      if(n == 0){
          if (list.size() == k){
              ans.add(new LinkedList<>(list));
          }
          return ans;
      }
      comb(n-1, k, list, ans);
      list.add(n);
      comb(n-1, k, list, ans);
      list.remove(list.size()-1);
      return ans;
    }
    
    public List<List<Integer>> combine(int n, int k) {
        return comb(n, k, new ArrayList<>(), new ArrayList<>());
    }
}