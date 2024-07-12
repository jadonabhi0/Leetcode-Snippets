class Solution {
    public int maximumGain(String s, int x, int y) {
        String top = "", bot = "";
        int topS = 0, botS = 0;

        if (x > y) {
            top = "ab";
            topS = x;
            bot = "ba";
            botS = y;
        } else {
            top = "ba";
            topS = y;
            bot = "ab";
            botS = x;
        }

        return maxScore(s, topS, botS, top, bot);
    }

    public int maxScore(String s, int fv, int sv, String top, String bot) {
        char fc = top.charAt(0), sc = top.charAt(1);
        int score = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == fc && c == sc) {
                sb.deleteCharAt(sb.length() - 1);
                score += fv;
            } else {
                sb.append(c);
            }
        }

        fc = bot.charAt(0);
        sc = bot.charAt(1);
        StringBuilder rm = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            if (rm.length() > 0 && rm.charAt(rm.length() - 1) == fc && c == sc) {
                rm.deleteCharAt(rm.length() - 1);
                score += sv;
            } else {
                rm.append(c);
            }
        }

        return score;
    }
}
