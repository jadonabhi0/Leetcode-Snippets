class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
       String str = strs[0];
        int n = str.length();
        int counter = 1;
        int flag = 0;
        String res = "";
        for (int i = 0; i < n; i++) {
            String sub = str.substring(0,counter);
            
            for (int j = 1; j < strs.length; j++) {
              
                String ss = strs[j].substring(0, counter);
                if (ss.equals(sub)){
                    flag++;
                }else{
                    break;
                }
            }

            counter++;
            if (flag == strs.length-1){
                res = sub;
                flag=0;
            }else {
                break;
            }
        }


        return res;
    }
}