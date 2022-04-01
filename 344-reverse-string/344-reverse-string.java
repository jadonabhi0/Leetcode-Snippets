class Solution {
   
    public void reverseString(char[] s) {
     int i = 0;
     int j = s.length-1;
        while(i<j){
          
            char first = s[i];
            char last = s[j];
            char temp = first;
            s[i] = last;
            s[j] = temp;
            i++;
            j--;
        }
        
    }
    
    
    
}