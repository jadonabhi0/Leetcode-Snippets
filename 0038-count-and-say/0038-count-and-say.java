class Solution {
    public String countAndSay(int n) {

        if(n == 1) return "1";

        String res = "11";

        for(int i = 3 ; i <= n ; i++){

            StringBuffer sb = new StringBuffer();
            int cnt = 1;
            char ch = ' ';

            for(int j = 0 ; j < res.length()-1 ; j++){
                ch = res.charAt(j);
                if(res.charAt(j+1) == ch){
                    cnt++;
                }else{
                    sb.append(cnt);
                    sb.append(ch);
                    cnt = 1;
                }
            }

            ch = res.charAt(res.length()-1);    
            sb.append(cnt);
            sb.append(ch);

            res = sb.toString();

        }
        return res;
    }
}