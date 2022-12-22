class Solution {
    public String countAndSay(int n) {
        String res = "11";
        if(n == 1) return "1";
        // if(n == 2) return res;
        for(int i = 3 ; i <= n ; i++){
            StringBuffer sb = new StringBuffer();
            int count = 1;
            char ch = ' ';
            for(int j = 0 ; j < res.length()-1 ; j++){
                ch = res.charAt(j);
                if(ch == res.charAt(j+1)){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(ch);
                    count = 1;
                    
                }
                
                
            }
            ch = res.charAt(res.length()-1);
            sb.append(count);
            sb.append(ch);
            res = sb.toString();
            
        }
        return res;
    }
}
