class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] map = new int[1001];
        int[] res = new int[1001];
        int count = 0;
        for(int i : nums1){
            map[i]++;
        }

        for(int i : nums2){
            if(map[i] > 0){
                res[count++] = i;
                map[i]--;
            }
        }
        return Arrays.copyOfRange(res,0,count);
    }
}