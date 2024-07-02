class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0; int j = 0;
        while(i < l1 && j < l2){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++; j++;
            }else if(nums1[i] > nums2[j]) j++;
            else i++;
        }

        int ans[] = new int[list.size()];
        int c = 0;
        for(int ii : list) ans[c++] = ii;
        return ans;
    }
}