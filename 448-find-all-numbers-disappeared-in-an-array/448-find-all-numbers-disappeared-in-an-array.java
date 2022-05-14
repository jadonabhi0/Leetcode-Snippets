class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean[] array = new boolean[nums.length+1];
    
        for(int i : nums){
            array[i] = true;
        }    
        
        for(int i = 1 ; i < array.length ; i++){
            if(!array[i]) list.add(i);
        }
        return list;
    }
}