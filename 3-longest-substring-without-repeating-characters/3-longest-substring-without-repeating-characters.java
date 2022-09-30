class Solution {
    public int lengthOfLongestSubstring(String s) {
        // BY USING SLIDING WINDOW TECHNIQUE VARIABLE SIZE
        int i = 0;
        int j = 0;
        int maxlen = 0;
        HashSet<Character> set = new HashSet<>();
        while(j < s.length()){
            char ch = s.charAt(j);
            if(!set.contains(ch)){
                set.add(ch);
                j++;
                maxlen = Math.max(set.size(), maxlen);
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxlen;
    }
}