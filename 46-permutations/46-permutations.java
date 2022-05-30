class Solution {
    
    public void perm(int[] array,int idx, List<Integer> list, List<List<Integer>> ans, boolean[] vis){
        if(idx == array.length){
            ans.add(new LinkedList<>(list));
            return;
        }
        
        for (int i = 0 ; i < array.length ; i++){
            if (vis[i]) continue;
            vis[i] = true;
            list.add(array[i]);
            perm(array ,idx+1, list,ans,vis);
            list.remove(list.size()-1);
            vis[i] = false;
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        boolean[] vis = new boolean[nums.length];
        perm(nums, 0, new LinkedList<>(), list,vis);
        
        return list;
    }
}