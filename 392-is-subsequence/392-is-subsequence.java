class Solution {
   public static boolean isSubsequence(String s, String t) {
       if(s.length() == 0) return true;
        int count = 0;
        String str1 = null;
        for(int i = 0 ; i < t.length() ; i++) {

            if (count < s.length()) {
                str1 = s.charAt(count) + "";
            }
            String str2 = t.charAt(i) + "";
            if (str1.equals(str2)) {
                count++;
            }
        }

        if(count == s.length()){
            return true;
        }
        
        return false;
    }
}