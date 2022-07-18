class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i : candies) if(max < i) max = i;

        for(int val : candies){
            list.add(val + extraCandies >= max);
        }
           
        
        return list;
    }
}