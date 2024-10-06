class Solution {
    private List<String> convert(String sentence) {
        sentence += " ";
        List<String> ans = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                ans.add(word.toString());
                word.setLength(0); // Clear the StringBuilder for the next word
            } else {
                word.append(sentence.charAt(i));
            }
        }

        return ans;
    }

    public boolean areSentencesSimilar(String x, String y) {
        // Ensure x is always the longer sentence to avoid else-if conditions
        if (x.length() < y.length()) {
            String temp = x;
            x = y;
            y = temp;
        }

        // First, store the words from both sentences
        List<String> vx = convert(x);
        List<String> vy = convert(y);

        int l = 0;
        // Match words from the prefix part
        for (int i = 0; i < vy.size(); i++) {
            if (vx.get(i).equals(vy.get(i))) {
                l++;
            } else {
                break;
            }
        }

        int ind = vx.size() - 1, r = vy.size();
        // Match words from the suffix part
        for (int i = vy.size() - 1; i >= 0; i--) {
            if (vy.get(i).equals(vx.get(ind))) {
                ind--;
                r = i;
            } else {
                break;
            }
        }

        // Check if the suffix overlaps with the prefix
        return r <= l;
    }
}