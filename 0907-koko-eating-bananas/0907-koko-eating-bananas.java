class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minS = 1, highS = 1000000000;

        while(minS < highS){
            int mid = minS + (highS - minS) / 2, total = 0;

            for(int bananas : piles){
                //count total lours to eat;
                total += (int) Math.ceil((double) bananas / mid);


                if(total > h) break;
            }

            if(total <= h){
                highS = mid;
            }else{
                minS = mid + 1;
            }

        }
        return minS;
        
    }
}



