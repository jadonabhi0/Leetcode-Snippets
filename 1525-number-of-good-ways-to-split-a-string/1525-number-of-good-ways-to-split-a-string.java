class Solution {
   
    public int numSplits(String s) {
        int len = s.length();
        int[] left = new int[len];
        int[] right = new int[len];
        int track = 0;
        int count = 0;
        // for left iteration
        
        Set<Integer> set1 = new HashSet<>();
        for(int i = 0 ; i < len ; i++){
            int ch = s.charAt(i);
            set1.add(ch);
            left[i] = set1.size();
        }
        
        
        // for right iteartion 
        
        track = 0;
        Set<Integer> set2 = new HashSet<>();
        for(int i = len-1 ; i >= 0 ; i--){
            int ch = s.charAt(i);
            set2.add(ch);
            right[i] = set2.size();
        }
        
        
        for(int i = 0 ; i < len-1 ; i++){
            if(left[i] == right[i+1]) count++;
        }
        return count;
    }
}