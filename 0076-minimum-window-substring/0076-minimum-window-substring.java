class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int[] freqT = new int[128];
        int[] freqS = new int[128];

        for (char ch : t.toCharArray()) freqT[ch]++;

        int i = 0, have = 0, need = t.length();
        int min = Integer.MAX_VALUE, start = 0;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            freqS[ch]++;

            if (freqT[ch] > 0 && freqS[ch] <= freqT[ch]) {
                have++;
            }

            // Shrink window
            while (have == need) {
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    start = i;
                }

                char fch = s.charAt(i);
                freqS[fch]--;
                if (freqT[fch] > 0 && freqS[fch] < freqT[fch]) {
                    have--;
                }
                i++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
