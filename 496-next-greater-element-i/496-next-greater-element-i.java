class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i : nums2){
            while(st.size() != 0 && st.peek() < i){
                map.put(st.pop(), i);
            }
            st.push(i);
            
        }
        int[] ans = new int[nums1.length];
        
        for(int i = 0 ; i < ans.length ; i++){
            ans[i] = map.getOrDefault(nums1[i],-1);
        }
        
        return ans;
    }
}