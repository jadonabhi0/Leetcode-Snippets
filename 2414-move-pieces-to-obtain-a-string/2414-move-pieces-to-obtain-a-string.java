class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0, n = start.length();

        while(i < n || j < n){

        
            while(i < n && start.charAt(i) == '_')i++;
            while(j < n && target.charAt(j) == '_')j++;


            if(i == n || j == n){
                return (i == n && j == n);
            }

            char schar = start.charAt(i);
            char tchar = target.charAt(j);

            if(schar!=tchar || (schar=='L' && i<j) || (schar=='R' && i>j))return false;

            i++;j++;
        }
        return i == n && j == n;

    }
}