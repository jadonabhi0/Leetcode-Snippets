class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList)set.add(s);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int transformation = 1;;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){

                String rm = q.poll();

                if(rm.equals(endWord)) return transformation;

                char[] arr = rm.toCharArray();

                for(int i = 0 ; i < arr.length ; i++){
                    char orgChar = arr[i];
                    for(char ch = 'a' ; ch <= 'z' ; ch++){
                       arr[i] = ch;
                        String newStr = new String(arr);
                       if(set.contains(newStr)){
                            q.add(newStr);
                            set.remove(newStr);
                       } 
                    }
                    arr[i] = orgChar;
                }

            }
            transformation++;

        }
        return 0;
        
    }
}