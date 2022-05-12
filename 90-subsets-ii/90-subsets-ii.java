class Solution {
    
     public static List<List<Integer>> generateSubset(int[] array, int pos, List<Integer> list, List<List<Integer>> ans){
         
       
        ans.add(new LinkedList<>(list));

        for (int i = pos ; i < array.length ; i++){
            if(i > pos && array[i] == array[i-1]) continue;
            list.add(array[i]);
            generateSubset(array, i+1, list, ans);
            list.remove(list.size()-1);
        }
        return ans;
    }
    
    
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return generateSubset(nums, 0,new ArrayList<>(), new ArrayList<>());
    }
}