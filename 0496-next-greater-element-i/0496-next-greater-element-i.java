class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
       

        for(int i = nums2.length - 1; i >= 0; i--){
            int num = nums2[i];
            while(!st.isEmpty() && num > st.peek()){
                st.pop();
            }
            if(st.isEmpty()) map.put(num, -1);
            else map.put(num, st.peek());

            st.push(num);
        }

        int[] ans = new int[nums1.length];
        for(int i = 0 ; i  < ans.length ; i++) ans[i] = map.get(nums1[i]);
        
        return ans;
    }
}