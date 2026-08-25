class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;

        if (n == 0 || m == 0 || k == 0) {
            return ans;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0]+a[1], b[0]+b[1]));
        for(int i = 0 ; i < Math.min(n, k) ; i++){
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while(k-->0 && !pq.isEmpty()){
            int[] rm = pq.poll();
            ans.add(Arrays.asList(rm[0], rm[1]));

            if(rm[2] == m-1) continue;

            pq.offer(new int[]{rm[0], nums2[rm[2]+1], rm[2]+1});

        }
        return ans;
    }
}