class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return generate(candidates, target, 0, new ArrayList<>(), new ArrayList<>());
    }


    private List<List<Integer>> generate(int[] cand, int target, int idx, List<Integer> lst,  List<List<Integer>> ans) {

     if(target == 0){
        ans.add(new ArrayList<>(lst));
        return ans;
     }   

     if(idx == cand.length || target < 0) return ans;

     lst.add(cand[idx]);
     generate(cand, target - cand[idx], idx, lst, ans);
     lst.remove(lst.size() - 1);
     generate(cand, target, idx + 1, lst, ans);
     
     return ans;   

    }
}