class Solution {

    Map<Integer, Integer> dp = new HashMap<>();

    public int climbStairs(int n) {

        if(dp.containsKey(n)) return dp.get(n);
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int a = climbStairs(n-1);
        int b = climbStairs(n-2);
        dp.put(n, a+b);
        return a+b;
    }
}