import java.util.*;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sumM = 0;
        for (int roll : rolls) {
            sumM += roll;
        }
        int totalSum = mean * (n + m);
        int missingSum = totalSum - sumM;
        int baseValue = missingSum / n;
        int remainder = missingSum % n;
        
        if (baseValue <= 0 || baseValue > 6 || (baseValue == 6 && remainder > 0)) {
            return new int[]{};
        }
        
        int[] result = new int[n];
        Arrays.fill(result, baseValue);
        for (int i = 0; i < remainder; ++i) {
            result[i]++;
        }
        return result;
    }
}