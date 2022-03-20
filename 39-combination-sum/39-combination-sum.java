class Solution {
    
    public void sum(int[] array, int target,List<List<Integer>> list,List<Integer> ans, int st){
        if(target < 0) return;
        if(target == 0) list.add(new LinkedList<>(ans));
        for(int i = st ; i < array.length ; i++){
            ans.add(array[i]);
            sum(array,target-array[i],list,ans,i);
            ans.remove(ans.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        sum(candidates,target,list,ans,0);
        return list;
    }
}