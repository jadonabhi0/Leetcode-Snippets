class Solution {
    Map<Integer, Integer> dp = new HashMap<>();

    public int climbStairs(int n) {
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;

        if(dp.containsKey(n)) return dp.get(n);

        int a = climbStairs(n-1);
        int b = climbStairs(n-2);
        dp.put(n, a+b);
        return a+b;
    }
}