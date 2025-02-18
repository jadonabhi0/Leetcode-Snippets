class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int[] arr = new int[100000+1];
        Set<Integer> set = new HashSet<>();

        Arrays.fill(arr, Integer.MAX_VALUE);

        for(int i = 0 ; i < elements.length ; i++){
            int n = elements[i];

            if(set.contains(n)) continue;

            for(int j = n ; j < arr.length ; j+=n){
                if(arr[j] == Integer.MAX_VALUE){
                    arr[j] = i;
                }
            }

            set.add(n);

        }


        int[] ans = new int[groups.length];

        for(int i = 0 ; i < ans.length ; i++){
            if(arr[groups[i]] == Integer.MAX_VALUE){
                ans[i] = -1;
            }else{
                ans[i] = arr[groups[i]];
            }
        }

        return ans;
    }
}