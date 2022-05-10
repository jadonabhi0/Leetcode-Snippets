class Solution {
    
     public static void helper(List<List<Integer>> ans, List<Integer> list, int n, int k, int idx){
        if(list.size() == k && n == 0){
            ans.add(new LinkedList<>(list));
            return;
        }
        for (int i = idx ;i <= 9 ;i++){
            list.add(i);
            helper(ans, list, n-i, k, i+1);
            list.remove(list.size()-1);

        }

    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,new LinkedList<>(),n, k, 1 );
        return list;
    }
}