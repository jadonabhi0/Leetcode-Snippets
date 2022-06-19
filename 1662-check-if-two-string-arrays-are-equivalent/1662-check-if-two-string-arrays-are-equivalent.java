class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        String ans1 = "";
        String ans2 = "";
        
        for(String val1 : word1){
            ans1 += val1;
        }
        
        for(String val2 : word2){
            ans2 += val2;
        }
        
        return ans1.equals(ans2);
    }
}