class Solution {
    public long maxWeight(int[] pizzas) {

        Arrays.sort(pizzas);

        long maxWt = 0 ;
        int days = pizzas.length/4;
        int n = pizzas.length;

        int oddDays = days/2 + days%2;
        int evenDays = days - oddDays;

        for(int i = 0 ; i < oddDays ; i++){
            maxWt += pizzas[n-1 - i];
        }

        for(int i = 0 ; i < evenDays ; i++){
            maxWt += pizzas[n - oddDays - 2 - i*2];
        }
        
        return maxWt;
    }
}