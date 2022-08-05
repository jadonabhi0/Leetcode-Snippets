class Solution {
    public int numberOfArithmeticSlices(int[] array) {
        if(array.length < 3) return 0;
        int ans = 0;
        HashMap<Integer,Integer>[] map = new HashMap[array.length];
        for(int i = 0 ; i < array.length ; i++){
            map[i] = new HashMap<>();
        }

        for(int i = 1 ; i < map.length ; i++){
            for(int j = 0 ; j < i ; j++){
                long cd = (long)array[i] - (long)array[j];
                if(cd > Integer.MAX_VALUE || cd < Integer.MIN_VALUE) continue;;
                int ansEndingOnJ = map[j].getOrDefault((int)cd, 0);
                int ansEndingOnI = map[i].getOrDefault((int)cd, 0);
                ans += ansEndingOnJ;
                map[i].put((int)cd, ansEndingOnI + ansEndingOnJ + 1);
            }
        }
         return ans;
    }
}