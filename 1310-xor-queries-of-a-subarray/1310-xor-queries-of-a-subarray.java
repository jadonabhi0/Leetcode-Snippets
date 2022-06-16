class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int len = arr.length;
        int l = queries.length;
        
        int[] pre = new int[len];
        int[] ans = new int[l];
        
        // making prefix array
        pre[0] = arr[0];
        for(int i = 1 ; i < len ; i++){
            pre[i] = pre[i-1] ^ arr[i];
        }
        
        for(int i = 0 ; i < l ; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            
            if(left == 0) ans[i] = pre[right];
            else ans[i] = pre[right] ^ pre[left-1];
        }
        
        return ans;
    }
}