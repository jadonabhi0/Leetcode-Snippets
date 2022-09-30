class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer,Integer> map = new HashMap<>();
        int start = 0;
        map.put(cards[start], start);
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i< cards.length ; i++){
            if(!map.containsKey(cards[i])){
                map.put(cards[i], i);
            }else{
                min = Math.min(min, Math.abs(map.get(cards[i]) - i) + 1);
                map.put(cards[i], i);
            }
        }
         return min == Integer.MAX_VALUE ? -1 : min;
    }
}