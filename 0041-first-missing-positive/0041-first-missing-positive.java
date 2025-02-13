class Solution {
    public int firstMissingPositive(int[] nums) {
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if(i > 0){
                max = Math.max(max, i);
                set.add(i);
            }
        }

        for(int i = 1 ; i <= max ; i++){
            if(!set.contains(i)) return i;
        }
        return max == Integer.MIN_VALUE ? 1 : max+1;
    }
}