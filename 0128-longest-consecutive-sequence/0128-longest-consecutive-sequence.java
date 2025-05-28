class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(i);

        int ans = 0;
        int cnt = 0;

        for (int i : set) {
            int val = i;

            // is x is the part of strek then x-1 should not be in set.
            if (!set.contains(val - 1)) {
                while (set.contains(val++)) {
                    cnt++;
                }
            }

            ans = Math.max(ans, cnt);
            cnt = 0;

        }
        return ans;

    }
}