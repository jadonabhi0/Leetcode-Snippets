class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2) return false;
        int[] count = new int[26];
        for(int i = 0 ; i < len1 ; i++){
            count[s1.charAt(i)-'a']++;
        }
        for(int i = 0 ; i < len2 ; i++){
            count[s2.charAt(i)-'a']--;
            if(i-len1 >= 0){
                count[s2.charAt(i-len1)-'a']++;
            }
            if(allZero(count)) return true;
        }
        return false;
    }

    public boolean allZero(int[] array){
        for(int i : array){
            if(i != 0) return false;
        }
        return true;
    }
}