class Solution {
    public String reverseWords(String s) {
        String str = "";
        String[] array = s.split(" ");
        for(String st: array){
            str += new StringBuilder(st).reverse().toString();
            str += " ";
        }
        return str.trim();
    }
}