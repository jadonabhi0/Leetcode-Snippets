class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int ans = 0 ;
        int count = 0;

        for(int i : set){
            int val = i;
            count = 0;

            if(!set.contains(val-1)){
                while(set.contains(val++)) count++;
            }

            ans = Math.max(ans, count);
        }

        return ans;

    }
}