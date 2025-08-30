class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> t : tickets){
            String from = t.get(0);
            String to = t.get(1);
            map.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).add(t.get(1));
        }
        List<String> list= new ArrayList();
        dfs(map, list, "JFK");
        return list;
    }

    private void dfs(Map<String, PriorityQueue<String>> map, List<String> lst, String from){
        PriorityQueue<String> pq = map.get(from);
        while(pq != null && !pq.isEmpty()){
            dfs(map, lst, pq.poll());
        }
        lst.addFirst(from);
    }   

}