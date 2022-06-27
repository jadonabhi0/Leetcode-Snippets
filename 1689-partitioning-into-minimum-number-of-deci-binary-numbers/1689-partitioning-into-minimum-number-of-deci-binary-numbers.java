class Solution {
    public int minPartitions(String n) {
        int ch = Integer.MIN_VALUE;
        for(int i = 0 ; i < n.length() ; i++){
            ch = Math.max(n.charAt(i)-'0',ch);
        }
        return ch;
    }
}