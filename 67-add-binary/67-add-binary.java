class Solution {
    public String addBinary(String a, String b) {
        
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuffer sb = new StringBuffer();
        int c = 0;
        while(i >= 0 || j >= 0){
           int sum = 0;
        
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            sum += c;
            
            sb.append(sum % 2);
            c = sum/2;
            
        }
        if(c != 0) sb.append(c);
            return sb.reverse().toString();
        
    }
}