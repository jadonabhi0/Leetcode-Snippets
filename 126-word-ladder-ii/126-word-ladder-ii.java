class Solution {
    
    private final List<List<String>> res = new ArrayList<>();
    private List[] parent;
    private List<String> wordList;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        this.wordList = wordList;
        wordList.add(beginWord);
        
        final int wordLength = beginWord.length();
        final int totalWords = wordList.size();
        final boolean[] visited = new boolean[totalWords];
        visited[totalWords-1] = true;
        
        this.parent = new List[totalWords];
        
        final Queue<Integer> queue = new LinkedList<>();
        queue.offer(totalWords-1);
        
        int endWordIndex = -1;
        
        outerloop : while (!queue.isEmpty()) {
            final Set<Integer> newIndices = new HashSet<>();
            for (int i=0, n = queue.size(); i<n; i++) {
                Integer currIndex = queue.poll();
                String currWord = wordList.get(currIndex);
                for (int j=0; j<totalWords; j++) {
                    if (!visited[j] && isSequence(currWord, wordList.get(j))) {
                        if (!newIndices.contains(j)) queue.offer(j);
                        if (parent[j] == null) parent[j] = new LinkedList<Integer>();
                        parent[j].add(currIndex);
                        newIndices.add(j);
                    }
                }
            }
            
            for (Integer seq : newIndices) {
                if (wordList.get(seq).equals(endWord)) {
                    endWordIndex = seq;
                    break outerloop;
                }
                visited[seq] = true;
            }
        }
        
        if (endWordIndex == -1) return res;
        
        backTrackResult(endWordIndex, new LinkedList<>());
        
        return res;
    }
    
    private void backTrackResult(int index, LinkedList<String> list) {
        list.addFirst(wordList.get(index));
        if (parent[index] == null) {
            res.add(list);
        }
        else {
            for (Object i : parent[index]) {
                backTrackResult((Integer)i, new LinkedList<>(list));
            }
        }
    }
    
    private boolean isSequence(final String a, final String b) {
        int mismatchCount = 0;
        for (int i=0, n = a.length(); i<n; i++) {
            if (a.charAt(i) != b.charAt(i) && mismatchCount++ > 0) return false;
        }
        return true;
    }
}