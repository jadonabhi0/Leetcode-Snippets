class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] array = s.split(" ");
        int n = array[array.length-1].length();
        return n;
    }
}