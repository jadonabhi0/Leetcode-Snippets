class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < allowed.length() ; i++){
            set.add(allowed.charAt(i));
        }
        for(String s : words){
            boolean flag = false;
            for(int i = 0 ; i < s.length() ; i++){
                if(!set.contains(s.charAt(i))) break;
                if(i == s.length()-1) flag = true;
            }
            if(flag) ans++;
        }
        return ans;
    }
}