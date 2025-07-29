class Solution {
    public int characterReplacement(String s, int k) {
    
    
    	int[] frq = new int[27];
    	int i = 0;
    	int j = 0;
    	int ans = Integer.MIN_VALUE;
    	int maxCnt = 0;
    	
    	while(j < s.length()){
    	
           char ch = s.charAt(j);
    	
    	  frq[ch-'A']++;
    	  maxCnt = Math.max(maxCnt, frq[ch-'A']);
    	  
        if ((j - i + 1) - maxCnt > k) {
                frq[s.charAt(i) - 'A']--;
                i++;
        }

    	  ans = Math.max(ans, j - i + 1);
            j++;
    	  
    	
    	}
    	
    	return ans;
    
        
    }
}