class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int n = persons.length;
        int[] result = new int[n];
        
        
        // Create a TreeMap to track flower intervals and their frequencies.
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < flowers.length; i++) {
            // Increment the start time frequency.
            treeMap.put(flowers[i][0], treeMap.getOrDefault(flowers[i][0], 0) + 1);
            // Decrement the end time frequency (add 1 to end time to indicate the end of the interval).
            treeMap.put(flowers[i][1] + 1, treeMap.getOrDefault(flowers[i][1] + 1, 0) - 1);
        }
        
        // Create another TreeMap to accumulate the frequencies and track the number of flowers blooming at each moment.
        TreeMap<Integer, Integer> sum = new TreeMap<>();
        int prev = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            prev += entry.getValue();
            sum.put(entry.getKey(), prev);
        }
        
        // Calculate bloom statuses for each person.
        for (int i = 0; i < n; i++) {
            // Find the floor entry for the person's bloom time.
            Map.Entry<Integer, Integer> entry = sum.floorEntry(persons[i]);
            if (entry != null) {
                result[i] = entry.getValue(); // Store the number of blooming flowers at that time.
            }
        }


        return result;
    }
}