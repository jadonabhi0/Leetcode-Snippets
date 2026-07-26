class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        int[] tFreq = new int[128];
        int[] windowFreq = new int[128];

        // Frequency of characters required
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }

        int need = t.length();   // Total characters required
        int have = 0;            // Characters currently matched

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            windowFreq[ch]++;

            // If this character is useful and not exceeding required frequency
            if (tFreq[ch] > 0 && windowFreq[ch] <= tFreq[ch]) {
                have++;
            }

            // Window contains all required characters
            while (have == need) {

                // Update answer
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Remove left character
                char remove = s.charAt(left);
                windowFreq[remove]--;

                // If window becomes invalid
                if (tFreq[remove] > 0 && windowFreq[remove] < tFreq[remove]) {
                    have--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}