class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
       
//         List<String> res = new ArrayList<>();
//         HashSet<String> hs = new HashSet<>();
//         for(int i = 0; i <= s.length()-10; i++) {
//             String subs = s.substring(i, i + 10);
//             if(hs.contains(subs)) {
//                 if(!res.contains(subs)) {
//                     res.add(subs);
//                 }
//             }
//             else {
//                 hs.add(subs);
//             }
//         }
//         return res;
//     }
        
        
        HashSet<String> set = new HashSet<>();
        List<String> list = new LinkedList<>();
        int start = 0, end = 9;
        if(s.length()<10) return list;
        while(end != s.length()){
            String str = s.substring(start,end+1);
            if(set.contains(str)){
                if(!list.contains(str)){
                    list.add(str);
                }
            }else{
                set.add(str);
            }
            end++;start++;
        }
        return list;
    }
}