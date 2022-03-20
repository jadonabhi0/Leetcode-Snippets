class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if(s.length() == 1) return s;
        String[] array = s.split(" ");
        String newstr ="";
        for(int i = array.length-1 ; i >= 0 ; i--){
            if(!array[i].equals("")){
                newstr += array[i]+" ";
            }
        }
        return newstr.trim();
    }
}