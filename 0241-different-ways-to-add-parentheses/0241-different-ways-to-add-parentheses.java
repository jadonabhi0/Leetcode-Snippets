import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    HashMap<String, List<Integer>> m = new HashMap<>();
    
    public List<Integer> solveTopDown(String s) {
        if (m.containsKey(s)) return m.get(s);
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = solveTopDown(s.substring(0, i));
                List<Integer> right = solveTopDown(s.substring(i + 1));
                
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') ans.add(l + r);
                        else if (c == '-') ans.add(l - r);
                        else ans.add(l * r);
                    }
                }
            }
        }
        if (ans.isEmpty()) ans.add(Integer.parseInt(s));
        m.put(s, ans);
        return ans;
    }
    
    public List<Integer> diffWaysToCompute(String expression) {
        return solveTopDown(expression);
    }
}