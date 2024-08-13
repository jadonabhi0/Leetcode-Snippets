class Solution {
    
    public void helper(int[] array, List<List<Integer>> ans, List<Integer> list, int tar, int idx){
        if (tar == 0){
            ans.add(new LinkedList<Integer>(list));
            return;
        }
        if (tar < 0) return;

        for (int i = idx ; i < array.length ; i++){
            if (i > idx && array[i] == array[i-1]){
                continue;
            }
            
                list.add(array[i]);
                helper(array, ans, list, tar-array[i],i+1);
                list.remove(list.size()-1);
            
        }

    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, ans, new LinkedList<>(), target,0);
        return ans;
    }
}