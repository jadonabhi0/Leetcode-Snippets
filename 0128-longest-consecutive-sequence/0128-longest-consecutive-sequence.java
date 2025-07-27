class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int i : nums) set.add(i);
        int ans = 0, cnt = 0;

        for(int i : set){
            cnt = 0;
            int val = i;
            if(!set.contains(val-1)){
                while(set.contains(val++)) cnt++;
            }

            ans = Math.max(ans, cnt);

        }

        return ans;
    
    }
}