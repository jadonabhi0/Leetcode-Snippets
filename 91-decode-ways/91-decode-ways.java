class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int numDecodings(String str) {
        if(map.containsKey(str)) return map.get(str);
        if(str.length() == 0) return 1;
        if(str.charAt(0) == '0') return 0;

        int c1 = numDecodings(str.substring(1));
        int c2 = 0;
        if(str.length() >= 2 && Integer.parseInt(str.substring(0,2)) <= 26){
            c2 = numDecodings(str.substring(2));
        }
        map.put(str, c1+c2);
        return c1 + c2;
    }
}