class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int findTheLongestSubstring(String s) {
        // Map vowels to their respective positions in the bitmask
        HashMap<Character, Integer> vowelPosition = new HashMap<>();
        vowelPosition.put('a', 0);
        vowelPosition.put('e', 1);
        vowelPosition.put('i', 2);
        vowelPosition.put('o', 3);
        vowelPosition.put('u', 4);

        // HashMap to store the first occurrence of each state
        HashMap<Integer, Integer> lastOccurred = new HashMap<>();
        lastOccurred.put(0, -1); // Initial state with no vowels seen
        
        int cur = 0; // Bitmask to track the parity of vowel counts
        int maxLen = 0; // Result variable to store the maximum length
        
        for (int r = 0; r < s.length(); r++) {
            char currentChar = s.charAt(r);

            if (isVowel(currentChar)) {
                // Toggle the bit for the current vowel
                cur ^= (1 << vowelPosition.get(currentChar));
            }

            // If the current state has been seen before, calculate the length
            if (lastOccurred.containsKey(cur)) {
                maxLen = Math.max(maxLen, r - lastOccurred.get(cur));
            } else {
                // Store the first occurrence of this state
                lastOccurred.put(cur, r);
            }
        }

        return maxLen;
    }
}