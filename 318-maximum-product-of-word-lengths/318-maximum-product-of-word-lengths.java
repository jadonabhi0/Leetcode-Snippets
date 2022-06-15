class Solution {
    public int maxProduct(String[] array) {
        int len = array.length;
        int[] values = new int[len];

        for (int i = 0 ; i < len ; i++){
            int mask = 0;

            for (int j = 0 ; j < array[i].length() ; j++){
                mask |= 1 << array[i].charAt(j)-'a';
            }

            values[i] = mask;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < values.length-1 ; i++){

            for (int j = i + 1 ; j < values.length ; j++){

                if ((values[i] & values[j]) == 0){
                    max = Math.max(max, array[i].length() * array[j].length() );
                }
            }
        }
        if(max == Integer.MIN_VALUE) return 0;
        return max;
    }
}