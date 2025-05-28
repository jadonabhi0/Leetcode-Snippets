class Solution {
public int reversePairs(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    return mergeSort(nums, 0, nums.length - 1);
}

private int mergeSort(int[] nums, int left, int right) {
    if (left >= right) return 0;

    int mid = left + (right - left) / 2;
    int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

    // Count reverse pairs
    int j = mid + 1;
    for (int i = left; i <= mid; i++) {
        while (j <= right && (long) nums[i] > 2L * nums[j]) {
            j++;
        }
        count += j - (mid + 1);
    }

    // Merge the sorted halves
    merge(nums, left, mid, right);
    return count;
}

private void merge(int[] nums, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;

    while (i <= mid && j <= right) {
        if (nums[i] <= nums[j]) {
            temp[k++] = nums[i++];
        } else {
            temp[k++] = nums[j++];
        }
    }

    while (i <= mid) {
        temp[k++] = nums[i++];
    }

    while (j <= right) {
        temp[k++] = nums[j++];
    }

    // Copy back to the original array
    for (int p = 0; p < temp.length; p++) {
        nums[left + p] = temp[p];
    }
}

}