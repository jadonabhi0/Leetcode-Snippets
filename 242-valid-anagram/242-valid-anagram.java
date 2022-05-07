class Solution {
    public boolean isAnagram(String r, String m) {
        if(r.length() != m.length()) return false;
        int[] array1 = new int [26];
        for(int i = 0 ; i < r.length() ; i++){
            array1[r.charAt(i)-'a']++;
        }
        int[] array2 = new int [26];
        for(int i = 0 ; i < m.length() ; i++){
            array2[m.charAt(i)-'a']++;
        }
        int flag = 0;
        for(int i = 0 ; i < r.length() ; i++){
            if((array2[r.charAt(i)-'a'] -array1[r.charAt(i)-'a']) == 0){
                flag += 1;
            }
        }
        if(flag == r.length()){
            return true;
        }
        return false;
    }
}