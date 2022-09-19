class Solution {
    public String longestCommonPrefix(String[] strs) {
        return lcp(strs, 0, strs.length - 1);
    }
    
    public String lcp(String[] array, int l, int r){
        if(l == r){
            return array[l];
        }else{
            int mid = (l+r)/2;
            String ls = lcp(array, l, mid);
            String rs = lcp(array, mid+1, r);
            return commonPrefix(ls, rs);
        }
    }
    
    public String commonPrefix(String s1, String s2){
        int min = Math.min(s1.length(), s2.length());
        for(int i = 0 ; i < min ; i++){
            if(s1.charAt(i) != s2.charAt(i)) return s1.substring(0, i);
        }
        return s1.substring(0, min);
    }
    
}