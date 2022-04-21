class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i : nums1){
            set1.add(i);
        }
        for(int j : nums2){
            set2.add(j);
        }
        
        int c = 0 ;
        for(int i : set1){
            if(set2.contains(i)){
                c++;
            }
        }
        int a = 0;
        int [] ans = new int[c];
        for(int i : set1){
            if(set2.contains(i)){
                ans[a++] = i;
            }
        }
        return ans;
    }
}