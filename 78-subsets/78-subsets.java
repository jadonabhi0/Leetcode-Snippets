class Solution {
    
    public static  List<List<Integer>> generateSubset(int[] array, int idx,List<Integer> list, List<List<Integer>> ans){
        if(array.length == idx){
            ans.add(new ArrayList<>(list));
            return  ans;
        }

        generateSubset(array, idx+1, list,ans);
        list.add(array[idx]);
        generateSubset(array, idx+1, list, ans);
        list.remove(list.size()-1);
        return ans;
    }
    
    
    public List<List<Integer>> subsets(int[] nums) {
        return generateSubset(nums, 0, new ArrayList<>(), new ArrayList<>());
    }
}