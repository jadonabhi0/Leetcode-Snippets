class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();

        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String ana = new String(chars);
            if (!map.containsKey(ana)) {
                map.put(ana, new ArrayList<>());
            }
            map.get(ana).add(s);
        }

        List<List<String>> ans = new ArrayList<>();
        for(List lst : map.values()) ans.add(lst);
        return ans;
    }
}