class Solution {
    HashMap<Character, Integer> map = new HashMap<>();
    public int distinctSubseqII(String s) {
        int [] dp = new int [s.length()+1];
        dp[0]  = 1;
        int mod = (int)1e9+7;
        for (int i = 0 ; i < s.length() ; i++){
            if (!map.containsKey(s.charAt(i))){
                dp[i+1] = (2 * dp[i] % mod ) % mod;
            }else{
                dp[i+1] = (((2 * dp[i] % mod) % mod - dp[map.get(s.charAt(i)) - 1] + mod ) % mod);
            }
            map.put(s.charAt(i), i+1);
        }
//        System.out.println(Arrays.toString(dp));
//        System.out.println(map);
        return dp[s.length()]-1 % mod;
    }
}