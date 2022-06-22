class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for(char val : letters){
            if(val > target) return val;
        }
        return letters[0];
    }
}