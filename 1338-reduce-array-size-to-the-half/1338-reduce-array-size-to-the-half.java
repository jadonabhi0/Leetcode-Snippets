class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : arr) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> container = new PriorityQueue<>((Integer a, Integer b) -> -a.compareTo(b));
        for (Integer val : counter.values()) {
            container.add(val);
        }
        
        int sum = 0;
        for (int count = 1; !container.isEmpty(); count++) {
            sum += container.poll();
            if (sum >= arr.length/2) {
                return count;
            }
        }
        
        return counter.size();
    }
}