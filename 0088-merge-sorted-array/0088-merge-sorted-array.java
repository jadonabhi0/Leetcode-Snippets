class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
       int i = m - 1;       // Pointer for nums1
        int j = n - 1;       // Pointer for nums2
        int k = m + n - 1;   // Pointer for placement in nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Copy remaining elements from nums2 if any
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }
}