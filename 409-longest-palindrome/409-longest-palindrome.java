class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
        }
        
        int ans = 0;
        
        
        // In this technique we are judging the solution on the basis of char occurance.
        
        for(int v : map.values()){
            ans += v/2 * 2;
            
            if(ans % 2 == 0 && v % 2 == 1) ans++;
            
        }
        return ans;
    }
}