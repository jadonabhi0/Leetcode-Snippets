class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int ans = 0;
        int n = s.length();
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            if((i-start+1)-maxFreq > k){
                char left = s.charAt(start); 
                map.put(left, map.get(left) - 1); 
                start++;
            }

            ans = Math.max(ans, i-start+1);
        }

        return ans;

    }
}