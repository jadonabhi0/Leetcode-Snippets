class Solution {
        public boolean maxSubstringLength(String s, int k) {
    
            if(k == 0) return true;

            Map<Character, Integer> fidx = new HashMap<>();
            Map<Character, Integer> lidx = new HashMap<>();
            Map<Character, Integer> freMap = new HashMap<>();

            //storing first, last idx and frequency of each char
            for(int i = 0 ; i < s.length() ; i++){
                char ch = s.charAt(i);

                fidx.putIfAbsent(ch, i);
                lidx.put(ch, i);
                freMap.put(ch, freMap.getOrDefault(ch, 0)+1);
            }


            // trying to make valid intervals
            ArrayList<int[]> intervals = new ArrayList<>();
            
            for(int i : fidx.values()){
                for(int j : lidx.values()){
                    int cnt = 0;
                    if(i <= j){
                        for(char c : freMap.keySet()){
                            if(i <= fidx.get(c) && lidx.get(c) <= j){
                                cnt += freMap.get(c);
                            }
                        }

                        if(cnt == j-i+1 && cnt < s.length()){
                            intervals.add(new int[]{i, j});
                        }
                    }
                }
            }
           

            intervals.sort(Comparator.comparingInt(a -> a[1] - a[0]));

            List<int[]> res = new LinkedList<>();

            for(int[] interval : intervals){
                int i = interval[0], j = interval[1];
                boolean isOverLapping = true;

                for(int[] existing : res){
                    if(!(existing[1] < i || existing[0] > j)){
                        isOverLapping = false;
                        break;
                    }
                }

                if (isOverLapping) {
                    res.add(new int[]{i, j});
                }
            }
            
            return res.size() >= k;
        }
    }
