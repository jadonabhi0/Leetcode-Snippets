 class Solution {
     
    public boolean helper(String s){
        int l = 0;
        int r = s.length() -1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        String str = "";
        for(int i = 0 ;i < s.length() ; i++){
            int v = s.codePointAt(i);
            if(v >= 97 && v <= 122 || v >= 65 && v <= 90 || v >= 48 && v <= 57){
                str += s.charAt(i)+"";
            }
        }
        str = str.toLowerCase();
        return helper(str);
    }  
}