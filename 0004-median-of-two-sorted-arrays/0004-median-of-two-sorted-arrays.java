class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        // Ensure nums1 is the smaller array
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int reqE = (n1 + n2 + 1) / 2; // total required elements in left partition
        int lo = 0, hi = n1;

        while (lo <= hi) {
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            int mid1 = (lo + hi) / 2;
            int mid2 = reqE - mid1;

            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return ((double)Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return (double)Math.max(l1, l2);
                }
            }

            if (l1 > r2) hi = mid1 - 1;
            else lo = mid1 + 1;
        }

        return 0; // This should never be reached
    }
}
