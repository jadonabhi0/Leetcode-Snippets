class Solution {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int c = 0;
        
        for(int i : nums){
            
            if(i % 2 == 0 ){
                nums[c++] = i;
            }
            else{
                list.add(i);
            }
        }
        
        for(int i : list){
            nums[c++] = i;
        }
         return nums;
    }
}